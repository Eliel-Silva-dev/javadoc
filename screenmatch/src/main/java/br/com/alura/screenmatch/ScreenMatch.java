package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.Episode;
import br.com.alura.screenmatch.model.Film;
import br.com.alura.screenmatch.model.Series;
import br.com.alura.screenmatch.services.CalcTemp;
import br.com.alura.screenmatch.services.FilterRecommendation;

import java.util.ArrayList;

public class ScreenMatch {

    public static void main(String[] args) {

        Film meuFilme = new Film();
        meuFilme.setNome("O poderoso chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("Duração do filme: " + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());
        //meuFilme.somaDasAvaliacoes = 10;
        //meuFilme.totalDeAvaliacoes = 1;
        //System.out.println(meuFilme.pegaMedia());

        Series lost = new Series();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodeosPorTemporada(10);
        lost.setMinutosPorEpisodeo(50);
        System.out.println("Duração para maratonar Lost: " + lost.getDuracaoEmMinutos());

        Film outroFilme = new Film();
        outroFilme.setNome("Avatar");
        outroFilme.setAnoDeLancamento(2023);
        outroFilme.setDuracaoEmMinutos(200);

        CalcTemp calculadora = new CalcTemp();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FilterRecommendation filtro = new FilterRecommendation();
        filtro.filter(meuFilme);

        Episode episodio = new Episode();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filter(episodio);

        ArrayList<Film> filmsList = new ArrayList<>();
        filmsList.add(meuFilme);
        filmsList.add(outroFilme);

        System.out.println("Tamanho da lista: " +filmsList.size());
        System.out.println("Primeiro Filme: " +filmsList.getFirst());
        System.out.println(filmsList);
    }
}
