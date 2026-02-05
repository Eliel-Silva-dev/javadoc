package br.com.alura.screenmatch_spring_boot.dto;

import br.com.alura.screenmatch_spring_boot.model.Categoria;

public record SerieDTO(
        Long id,
        String titulo,
        Integer totalTemporadas,
        Double avaliacao,
        Categoria genero,
        String atores,
        String poster,
        String sinopse
) {
}
