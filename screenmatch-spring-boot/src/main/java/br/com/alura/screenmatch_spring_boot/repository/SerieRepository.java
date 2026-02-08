package br.com.alura.screenmatch_spring_boot.repository;

import br.com.alura.screenmatch_spring_boot.model.Categoria;
import br.com.alura.screenmatch_spring_boot.model.Episode;
import br.com.alura.screenmatch_spring_boot.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);

    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, Double avaliacao);

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findByGenero(Categoria categoria);

    List<Serie> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(int totalTemporadas, double avaliacao);

    @Query("SELECT s FROM Serie s WHERE s.totalTemporadas <= :totalTemporadas AND s.avaliacao >= :avaliacao")
    List<Serie> seriesPorTemporadaEAvaliacao(int totalTemporadas, double avaliacao);

    @Query("SELECT e from Serie s JOIN s.episodes e WHERE e.title ILIKE %:trechoEpisodio%")
    List<Episode> episodiosPorTrecho(String trechoEpisodio);

    @Query("SELECT e FROM Serie s JOIN s.episodes e WHERE s = :serie ORDER BY e.evaluation DESC LIMIT 5")
    List<Episode> topEpisodiosPorSerie(Serie serie);

    @Query("SELECT e FROM Serie s JOIN s.episodes e WHERE s = :serie AND YEAR(e.realiseDate) >= :anoLancamento")
    List<Episode> episodiosPorSerieEAno(Serie serie, int anoLancamento);

    @Query("SELECT s FROM Serie s " +
            "JOIN s.episodes e " +
            "GROUP BY s " +
            "ORDER BY MAX(e.realiseDate) DESC LIMIT 5")
    List<Serie> encontrarEpisodiosMaisRecentes();
}
