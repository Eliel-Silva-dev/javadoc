package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.services.Classificavel;

public class Film extends Title implements Classificavel {
    private String director;

    public Film(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public String getDirector() {
        return this.director;
    }

    public  void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
    }
}
