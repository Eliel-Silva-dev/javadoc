package br.com.alura.screenmatch_spring_boot.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Entity
@Table(name = "episodeos")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numberSeason;

    private String title;

    private Integer numberEpisode;

    private Double evaluation;
    private LocalDate realiseDate;

    @ManyToOne
    private Serie serie;

    public Episode(Integer numberSeason, DataEpisode dataEpisode) {
        this.numberSeason = numberSeason;
        this.title = dataEpisode.title();
        this.numberEpisode = dataEpisode.number();

        try {
            this.evaluation = Double.valueOf(dataEpisode.rating());
        } catch (NumberFormatException ex) {
            this.evaluation = 0.0;
        }

        try {
            this.realiseDate = LocalDate.parse(dataEpisode.releaseDate());
        } catch (DateTimeParseException ex) {
            this.realiseDate = null;
        }
    }

    public Episode() {

    }

    public Integer getNumberSeason() {
        return numberSeason;
    }

    public void setNumberSeason(Integer numberSeason) {
        this.numberSeason = numberSeason;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberEpisode() {
        return numberEpisode;
    }

    public void setNumberEpisode(Integer numberEpisode) {
        this.numberEpisode = numberEpisode;
    }

    public Double getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Double evaluation) {
        this.evaluation = evaluation;
    }

    public LocalDate getRealiseDate() {
        return realiseDate;
    }

    public void setRealiseDate(LocalDate realiseDate) {
        this.realiseDate = realiseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "temporada=" + numberSeason +
                ", titulo='" + title + '\'' +
                ", numeroEpisodio=" + numberEpisode +
                ", avaliacao=" + evaluation +
                ", dataLancamento=" + realiseDate;
    }
}
