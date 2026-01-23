package br.com.alura.screenmatch_spring_boot.principal;

import br.com.alura.screenmatch_spring_boot.model.DadosSerie;
import br.com.alura.screenmatch_spring_boot.model.DataEpisode;
import br.com.alura.screenmatch_spring_boot.model.DataSeason;
import br.com.alura.screenmatch_spring_boot.service.ConsumoDeApi;
import br.com.alura.screenmatch_spring_boot.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        temporadas.forEach(System.out::println);

//        for (int i = 0; i <= data.totalTemporadas(); i++) {
//            List<DataEpisode> episodesSeason = temporadas.get(i).episodes();
//            for (int j = 0; j < episodesSeason.size(); j++) {
//                System.out.println("temporada: " + temporadas.get(i).number() + " - episódeo: " + episodesSeason.get(j).title());
//            }
//            System.out.println("");
//        }

        temporadas.forEach(t -> t.episodes().forEach(e -> System.out.println(e.title())));
    }
}
