package br.com.alura.tabela_fipe_spring.principal;

import br.com.alura.tabela_fipe_spring.service.ConsumoApi;
import br.com.alura.tabela_fipe_spring.service.ConverterDados;

import java.util.Scanner;

public class Principal {
    private Scanner scan = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverterDados conversor = new ConverterDados();

    private String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void showMenu () {
        var menu = """
                *** OPÇÔES ***
                Carro
                Moto
                Caminhão
                
                Digite uma das opções para consulta:
                """;

        System.out.println(menu);
        var opcao = scan.nextLine();
        String address;

        if (opcao.toLowerCase().contains("carr")) {
            address = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            address = URL_BASE + "motos/marcas";
        } else {
            address = URL_BASE + "caminhoes/marcas";
        }

        
    }
}
