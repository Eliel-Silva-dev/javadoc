package br.com.alura.screenmatch_spring_boot.principal;

import br.com.alura.screenmatch_spring_boot.model.DadosSerie;
import br.com.alura.screenmatch_spring_boot.model.DataSeason;
import br.com.alura.screenmatch_spring_boot.model.Episode;
import br.com.alura.screenmatch_spring_boot.model.Serie;
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
                    4 - Buscar serie por titulo
                    
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
        Optional<Serie> serieBuscada = repository.findByTituloContainingIgnoreCase(nomeSerie);
        if (serieBuscada.isPresent()) {
            System.out.println("Dados da série: " + serieBuscada.get());
        } else {
            System.out.println("Série não encontrada...");
        }
    }
}
