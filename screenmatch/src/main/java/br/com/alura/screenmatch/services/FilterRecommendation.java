package br.com.alura.screenmatch.services;

public class FilterRecommendation {
    private String recommendation;

    public void filter(Classificavel classificavel) {
        if(classificavel.getClassificacao() >= 4) {
            System.out.println("Está entre os preferidos no momento!");
        } else if(classificavel.getClassificacao() >= 2) {
            System.out.println("Muito bem avaliado");
        } else {
            System.out.println("Coloque na sua lista para assistir depois");
        }
    }
}
