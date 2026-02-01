package br.com.alura.screen_music.principal;

import br.com.alura.screen_music.model.Artist;
import br.com.alura.screen_music.model.ArtistType;
import br.com.alura.screen_music.model.Music;
import br.com.alura.screen_music.repository.ArtistRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final Scanner scan = new Scanner(System.in);
    private final ArtistRepository repository;

    public Principal(ArtistRepository repository) {
        this.repository = repository;
    }

    public void showMenu() {
        var opcao = -1;

        while (opcao != 9) {
            var menu = """
                     *** Screen Music ***
                    
                     1- Cadastrar artistas
                     2- Cadastrar músicas
                     3- Listar músicas
                     4- Buscar músicas por artistas
                     5- Pesquisar dados sobre um artista
                    
                     9 - Sair
                    """;
            System.out.println(menu);
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    pesquisarDadosDoArtista();
                    break;
                case 9:
                    System.out.println("Saindo do programa...");
                default:
                    System.out.println("Opção invalida, tente novamente...");
            }

        }
    }

    private void cadastrarArtista() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.println("Informe o nome do artista: ");
            var name = scan.nextLine();

            System.out.println("Informe o tipo desse artista: (solo, dupla, banda)");
            var type = scan.nextLine();

            ArtistType artistType = ArtistType.valueOf(type.toUpperCase());

            Artist artist = new Artist(name, artistType);

            repository.save(artist);

            System.out.println("Cadastrar novo artista? (S/N)");

            cadastrarNovo = scan.nextLine();
        }
    }

    private void cadastrarMusicas() {
        System.out.println("Cadastrar música de que artista? ");
        var name = scan.nextLine();

        Optional<Artist> artist = repository.findByNameContainingIgnoreCase(name);

        if (artist.isPresent()) {
            System.out.println("Informe o título da música: ");
            var nomeMusica = scan.nextLine();

            Music music = new Music(nomeMusica);

            music.setArtist(artist.get());

            artist.get().getMusics().add(music);

            repository.save(artist.get());
        } else {
            System.out.println("Artista não encontrada...");
        }
    }

    private void listarMusicas() {
        List<Artist> artist = repository.findAll();

        artist.forEach(a -> a.getMusics().forEach(System.out::println));
    }

    private void buscarMusicasPorArtista() {
        System.out.println("Buscar músicas de que artista? ");
        var name = scan.nextLine();
        List<Music> musicas = repository.searchMusicByArtist(name);
        musicas.forEach(System.out::println);
    }

    private void pesquisarDadosDoArtista() {
        System.out.println("Pesquisar dados sobre qual artista? ");
        var nome = scan.nextLine();
        //var resposta = ConsultaChatGPT.obterInformacao(nome);
        //System.out.println(resposta.trim());
    }
}
