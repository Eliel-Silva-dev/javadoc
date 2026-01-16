package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.Film;
import br.com.alura.screenmatch.model.Series;
import br.com.alura.screenmatch.services.CalcTemp;

public class ScreenMatch {

    public static void main(String[] args) {

        Film favorito = new Film();
        favorito.setNome("The matrix");
        favorito.setAnoDeLancamento(1999);
        favorito.setDuracaoEmMinutos(135);
        favorito.setIncluidoNoPlano(true);

        Film outro = new Film();
        outro.setNome("John Wick");
        outro.setAnoDeLancamento(2014);
        outro.setDuracaoEmMinutos(101);
        outro.setIncluidoNoPlano(true);

        Series serie = new Series();
        serie.setNome("La Casa de Papel");
        serie.setAnoDeLancamento(2017);
        serie.setIncluidoNoPlano(true);
        serie.setAtiva(true);
        serie.setTemporadas(5);
        serie.setEpisodeosPorTemporada(10);
        serie.setMinutosPorEpisodeo(45);

        CalcTemp calc = new CalcTemp();
        calc.inclui(favorito);
        calc.inclui(outro);
        calc.inclui(serie);

        System.out.println("Tempo total: " + calc.getTempoTotal());
    }
}
