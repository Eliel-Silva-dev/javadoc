package br.com.alura.screenmatch_spring_boot.principal;

import br.com.alura.screenmatch_spring_boot.model.DadosSerie;
import br.com.alura.screenmatch_spring_boot.model.DataSeason;
import br.com.alura.screenmatch_spring_boot.model.Serie;
import br.com.alura.screenmatch_spring_boot.repository.SerieRepository;
import br.com.alura.screenmatch_spring_boot.service.ConsumoDeApi;
import br.com.alura.screenmatch_spring_boot.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private Scanner scan = new Scanner(System.in);
    private ConsumoDeApi consumoApi = new ConsumoDeApi();
    private ConverteDados converter = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=49749daf";

    private List<DadosSerie> dataSeries = new ArrayList<>();

    SerieRepository repository;

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
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }
    }

    private void listarSeriesBuscadas() {
        List<Serie> series = repository.findAll();

//        series = dataSeries.stream()
//                .map(d -> new Serie(d))
//                .collect(Collectors.toList());
        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);

    }

    private void buscarSerieWeb() {
        DadosSerie dataSerie = getDataSerie();
        dataSeries.add(dataSerie);
        System.out.println(dataSerie);

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
        DadosSerie dadosSerie = getDataSerie();
        List<DataSeason> temporadas = new ArrayList<>();

        for (int i = 1; i <= dadosSerie.totalTemporadas(); i++) {
            var json = consumoApi.obtemDados(ENDERECO + dadosSerie.titulo().replace(" ", "+") + "&season=" + i + API_KEY);
            DataSeason dataSeason = converter.obterDados(json, DataSeason.class);
            temporadas.add(dataSeason);
        }
        temporadas.forEach(System.out::println);

    }
    
}
