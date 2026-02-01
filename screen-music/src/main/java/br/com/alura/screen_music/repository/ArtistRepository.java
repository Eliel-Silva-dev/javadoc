package br.com.alura.screen_music.repository;

import br.com.alura.screen_music.model.Artist;
import br.com.alura.screen_music.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findByNameContainingIgnoreCase(String nome);

    @Query("SELECT m FROM Artist a JOIN a.musics m WHERE a.name ILIKE %:artistName%")
    List<Music> searchMusicByArtist(String artistName);
}
