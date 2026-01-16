package br.com.alura.screenmatch.services;

import br.com.alura.screenmatch.model.Title;

public class CalcTemp {
    private int tempoTotal;

    public void inclui(Title title) {
        tempoTotal += title.getDuracaoEmMinutos();
    }

    public int getTempoTotal() {
        return tempoTotal;
    }
}
