package br.com.alura.screen_music.principal;

import java.util.Scanner;

public class Principal {
    private final Scanner scan = new Scanner(System.in);

    public void showMenu() {
        var opcao = -1;

        while (opcao != 0) {
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

//            switch (opcao) {
//
//            }

        }
    }


}
