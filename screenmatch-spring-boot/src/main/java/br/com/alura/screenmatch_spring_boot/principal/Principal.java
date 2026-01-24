package br.com.alura.screenmatch_spring_boot.principal;

import br.com.alura.screenmatch_spring_boot.model.DadosSerie;
import br.com.alura.screenmatch_spring_boot.model.DataEpisode;
import br.com.alura.screenmatch_spring_boot.model.DataSeason;
import br.com.alura.screenmatch_spring_boot.model.Episode;
import br.com.alura.screenmatch_spring_boot.service.ConsumoDeApi;
import br.com.alura.screenmatch_spring_boot.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner scan = new Scanner(System.in);
    private ConsumoDeApi consumoApi = new ConsumoDeApi();
    private ConverteDados converter = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=49749daf";

    public void showMenu() {
        System.out.println("Digite o nome da série para busca");
        var serieName = scan.nextLine();
        var json = consumoApi.obtemDados(ENDERECO + serieName.replace(" ", "+") + API_KEY);
        DadosSerie data = converter.obterDados(json, DadosSerie.class);
        System.out.println(data);

        List<DataSeason> temporadas = new ArrayList<>();

        for (int i = 1; i <= data.totalTemporadas(); i++) {
            json = consumoApi.obtemDados(ENDERECO + serieName.replace(" ", "+") + "&season=" + i + API_KEY);
            DataSeason dataSeason = converter.obterDados(json, DataSeason.class);
            temporadas.add(dataSeason);
        }
        //temporadas.forEach(System.out::println);

//        for (int i = 0; i <= data.totalTemporadas(); i++) {
//            List<DataEpisode> episodesSeason = temporadas.get(i).episodes();
//            for (int j = 0; j < episodesSeason.size(); j++) {
//                System.out.println("temporada: " + temporadas.get(i).number() + " - episódeo: " + episodesSeason.get(j).title());
//            }
//            System.out.println("");
//        }

        //temporadas.forEach(t -> t.episodes().forEach(e -> System.out.println(e.title())));

//        List<DataEpisode> dataEpisodes = temporadas.stream()
//                .flatMap(t -> t.episodes().stream())
//                .collect(Collectors.toList());
//
//        System.out.println("\nTop 5 episódios: ");
//        dataEpisodes.stream()
//                .filter(e -> !e.rating().equalsIgnoreCase("N/A"))
//                .sorted(Comparator.comparing(DataEpisode::rating).reversed())
//                .limit(5)
//                .forEach(System.out::println);

        System.out.println("\n Lista de episódios: ");
        List<Episode> episodes = temporadas.stream()
                .flatMap(t -> t.episodes().stream()
                        .map(d -> new Episode(t.number(), d)))
                .collect(Collectors.toList());

        episodes.forEach(System.out::println);

        System.out.println("Pesquise o episódeo pelo titulo: ");
        var trechoTitle = scan.nextLine();
        Optional<Episode> episodeBuscado = episodes.stream()
                .filter(e -> e.getTitle().toUpperCase().contains(trechoTitle.toUpperCase()))
                .findFirst();
        if (episodeBuscado.isPresent()) {
            System.out.println("Episódeo encontrado: ");
            System.out.println("temporada: " + episodeBuscado.get().getNumberSeason());
        } else {
            System.out.println("Episódeo não encontrado");
        }

//        System.out.println("Apartir de qual ano você gostaria de ver os episódeos? ");
//        var year = scan.nextInt();
//        scan.nextLine();
//
//        LocalDate searchDate = LocalDate.of(year, 1, 1);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        episodes.stream()
//                .filter(e -> e.getRealiseDate() != null && e.getRealiseDate().isAfter(searchDate))
//                .forEach(e -> System.out.println(
//                        "Temporada: " + e.getNumberSeason() + " Episódeo: " + e.getTitle()
//                                + " Data de lançamento: " + e.getRealiseDate().format(formatter)
//                ));
    }
}
