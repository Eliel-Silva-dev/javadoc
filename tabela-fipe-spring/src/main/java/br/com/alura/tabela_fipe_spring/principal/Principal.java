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
        

    }
}
