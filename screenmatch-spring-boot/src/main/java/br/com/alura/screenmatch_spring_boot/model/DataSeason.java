package br.com.alura.screenmatch_spring_boot.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record DataSeason(
        @JsonAlias("Season") Integer number,
        @JsonAlias("Episodes") List<DataEpisode> episodes
) {
}
