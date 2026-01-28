package br.com.alura.screenmatch_spring_boot.repository;

import br.com.alura.screenmatch_spring_boot.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
