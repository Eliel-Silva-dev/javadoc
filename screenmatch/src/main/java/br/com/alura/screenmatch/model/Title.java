package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.exceptions.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title> {

    private String nome;
    private int anoDeLancamento;
    private int duracaoEmMinutos;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;

    public Title(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Title(TituloOmdb myTitleOmdb) {
        this.nome = myTitleOmdb.title();

        if(myTitleOmdb.year().length() > 4) {
            throw new ErroDeConversaoDeAnoException("Não consegui fazer a conversão do ano.");
        }

        this.anoDeLancamento = Integer.valueOf(myTitleOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(myTitleOmdb.runtime().substring(0,2));
    }

    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
        System.out.println("Duração em minutos: " + duracaoEmMinutos);
        System.out.println("Incluido no plano: " + incluidoNoPlano);
    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return this.anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean getIncluidoNoPlano() {
        return this.incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return this.duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return this.totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Title oderTitle) {
        return this.getNome().compareTo(oderTitle.getNome());
    }

    @Override
    public String toString() {
        return "( nome = " +nome + ", " +
    "ano de lançamento = "  + anoDeLancamento + ", duração = " + duracaoEmMinutos + " )";
    }
}
