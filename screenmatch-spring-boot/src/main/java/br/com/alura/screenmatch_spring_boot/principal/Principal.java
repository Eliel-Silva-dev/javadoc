package br.com.alura.screenmatch_spring_boot.principal;

import br.com.alura.screenmatch_spring_boot.model.*;
import br.com.alura.screenmatch_spring_boot.repository.SerieRepository;
import br.com.alura.screenmatch_spring_boot.service.ConsumoDeApi;
import br.com.alura.screenmatch_spring_boot.service.ConverteDados;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner scan = new Scanner(System.in);
    private ConsumoDeApi consumoApi = new ConsumoDeApi();
    private ConverteDados converter = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=49749daf";

    SerieRepository repository;

    List<Serie> series = new ArrayList<>();

    Optional<Serie> serieBusca;

    public Principal(SerieRepository repository) {
        this.repository = repository;
    }

    public void showMenu() {
        var opcao = -1;

        while (opcao != 0) {
            var menu = """
                     1 - Buscar séries
                     2 - Buscar episódeos
                     3 - Listar séries buscadas
                     4 - Buscar série por titulo
                     5 - buscar série por ator
                     6 - Buscar top 5 séries
                     7 - Buscar séries por categoria
                     8 - Filtrar séries
                     9 - Buscar por trecho
                    10 - Buscar top 5 episódios por série
                    11 - Buscar episódios a partir de uma data
                    
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listarSeriesBuscadas();
                    break;
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    buscarSeriesPorAtor();
                    break;
                case 6:
                    buscarTop5Series();
                    break;
                case 7:
                    buscarSeriesPorCategoria();
                    break;
                case 8:
                    filtrarSeriesPorTemporadaEAvaliacao();
                    break;
                case 9:
                    buscarEpisodioPorTrecho();
                    break;
                case 10:
                    topEpisodiosPorSerie();
                    break;
                case 11:
                    buscarEpisodiosDepoisDeUmaData();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }


    private void listarSeriesBuscadas() {
        series = repository.findAll();
        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);

    }

    private void buscarSerieWeb() {
        DadosSerie dataSerie = getDataSerie();
        Serie serie = new Serie(dataSerie);
        repository.save(serie);
    }

    private DadosSerie getDataSerie() {
        System.out.println("Digite o nome da série para busca ");
        var nameSeason = scan.nextLine();
        var json = consumoApi.obtemDados(ENDERECO + nameSeason.replace(" ", "+") + API_KEY);
        DadosSerie data = converter.obterDados(json, DadosSerie.class);

        return data;
    }

    private void buscarEpisodioPorSerie() {
        listarSeriesBuscadas();
        System.out.println("Escolha uma série pelo nome");
        var nomeSerie = scan.nextLine();

        Optional<Serie> serie = repository.findByTituloContainingIgnoreCase(nomeSerie);
//        Optional<Serie> serie = series.stream().filter(
//                s -> s.getTitulo().toLowerCase().contains(nomeSerie.toLowerCase())
//        ).findFirst();

        if (serie.isPresent()) {
            var serieEncontrada = serie.get();

            List<DataSeason> temporadas = new ArrayList<>();

            for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
                var json = consumoApi.obtemDados(ENDERECO + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DataSeason dataSeason = converter.obterDados(json, DataSeason.class);
                temporadas.add(dataSeason);
            }
            temporadas.forEach(System.out::println);

            List<Episode> episodios = temporadas.stream().flatMap(t -> t.episodes().stream()
                    .map(
                            e -> new Episode(t.number(), e)
                    )).collect(Collectors.toList());

            serieEncontrada.setEpisodes(episodios);

            repository.save(serieEncontrada);

        } else {
            System.out.println("Temporada não encontrada...");
        }
    }

    private void buscarSeriePorTitulo() {
        System.out.println("Escolha uma série pelo nome: ");
        var nomeSerie = scan.nextLine();
        serieBusca = repository.findByTituloContainingIgnoreCase(nomeSerie);
        if (serieBusca.isPresent()) {
            System.out.println("Dados da série: " + serieBusca.get());
        } else {
            System.out.println("Série não encontrada...");
        }
    }

    private void buscarSeriesPorAtor() {
        System.out.println("Qual o nome para busca?");
        var nomeAtor = scan.nextLine();
        System.out.println("Avaliação apartir de qual valor?");
        var valorAvaliacao = scan.nextDouble();

        List<Serie> seriesEncontradas = repository.findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(nomeAtor, valorAvaliacao);

        System.out.println("Séries em que " + nomeAtor + " trabalhou: ");
        seriesEncontradas.forEach(
                s -> System.out.println(s.getTitulo() + ", avaliação: " + s.getAvaliacao())
        );
    }

    private void buscarTop5Series() {
        List<Serie> serieTop = repository.findTop5ByOrderByAvaliacaoDesc();
        serieTop.forEach(s ->
                System.out.println(s.getTitulo() + ", Avaliação: " + s.getAvaliacao()));
    }

    private void buscarSeriesPorCategoria() {
        System.out.println("Deseja buscar séries de que categoria/gênero? ");
        var nomeGenero = scan.nextLine();

        Categoria categoria = Categoria.fromPortugues(nomeGenero);

        List<Serie> seriesPorCategoria = repository.findByGenero(categoria);

        System.out.println("Séries da categoria " + nomeGenero);
        seriesPorCategoria.forEach(System.out::println);
    }

    private void filtrarSeriesPorTemporadaEAvaliacao() {
        System.out.println("Filtrar séries até quantas temporadas? ");
        var totalTemporadas = scan.nextInt();
        scan.nextLine();

        System.out.println("Com avaliação a partir de que valor? ");
        var avaliacao = scan.nextDouble();
        scan.nextLine();

        List<Serie> filtroSeries = repository.seriesPorTemporadaEAvaliacao(totalTemporadas, avaliacao);

        System.out.println("*** Séries filtradas ***");
        filtroSeries.forEach(s ->
                System.out.println(s.getTitulo() + "  - avaliação: " + s.getAvaliacao()));
    }

    private void buscarEpisodioPorTrecho() {
        System.out.println("Qual o nome do episodio para busca? ");
        var trechoEpisodio = scan.nextLine();

        List<Episode> episodiosEncontradas = repository.episodiosPorTrecho(trechoEpisodio);

        episodiosEncontradas.forEach(e ->
                System.out.printf("Serie: %s Temporada %s - Episídio %s - %s\n",
                        e.getSerie().getTitulo(), e.getNumberSeason(), e.getNumberEpisode(), e.getTitle())
        );
    }

    private void topEpisodiosPorSerie() {
        buscarSeriePorTitulo();

        if (serieBusca.isPresent()) {
            Serie serie = serieBusca.get();
            List<Episode> topEpisodios = repository.topEpisodiosPorSerie(serie);

            topEpisodios.forEach(e ->
                    System.out.printf("Serie: %s Temporada %s - Episídio %s - %s Avaliação: %s\n",
                            e.getSerie().getTitulo(),
                            e.getNumberSeason(),
                            e.getNumberEpisode(),
                            e.getTitle(),
                            e.getEvaluation())
            );
        }
    }

    private void buscarEpisodiosDepoisDeUmaData() {
        buscarSeriePorTitulo();

        if (serieBusca.isPresent()) {
            Serie serie = serieBusca.get();

            System.out.println("Digite o ano limite de lançamento");
            var anoLancamento = scan.nextInt();
            scan.nextLine();

            List<Episode> episodiosAno = repository.episodiosPorSerieEAno(serie, anoLancamento);

            episodiosAno.forEach(System.out::println);
        }
    }
}

