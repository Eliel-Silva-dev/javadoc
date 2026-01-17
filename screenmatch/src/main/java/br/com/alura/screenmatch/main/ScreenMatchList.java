package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.model.Film;
import br.com.alura.screenmatch.model.Series;
import br.com.alura.screenmatch.model.Title;

import java.util.ArrayList;

public class ScreenMatchList {
    public static void main(String[] args) {
        Film favorito = new Film("The Matrix", 1999);
        favorito.avalia(10);

        Film outro = new Film("John Wick", 2014);
        outro.avalia(9);

        Series serie = new Series("La Casa de Papel", 2017);

        ArrayList<Title> lista = new ArrayList<>();
        lista.add(favorito);
        lista.add(outro);
        lista.add(serie);

        for (Title item : lista) {
            System.out.println("Nome: " + item.getNome());
            if (item instanceof Film filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }
    }
}
