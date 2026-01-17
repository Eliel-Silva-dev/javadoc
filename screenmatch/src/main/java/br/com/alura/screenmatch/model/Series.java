package br.com.alura.screenmatch.model;

public class Series extends Title{
    private int temporadas;
    private boolean ativa;
    private int episodeosPorTemporada;
    private int minutosPorEpisodeo;

    public Series(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    @Override
    public int getDuracaoEmMinutos() {
        return temporadas * episodeosPorTemporada * minutosPorEpisodeo;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getEpisodeosPorTemporada() {
        return episodeosPorTemporada;
    }

    public void setEpisodeosPorTemporada(int episodeosPorTemporada) {
        this.episodeosPorTemporada = episodeosPorTemporada;
    }

    public int getMinutosPorEpisodeo() {
        return minutosPorEpisodeo;
    }

    public void setMinutosPorEpisodeo(int minutosPorEpisodeo) {
        this.minutosPorEpisodeo = minutosPorEpisodeo;
    }

    @Override
    public String toString() {
        return "Série: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
    }
}
