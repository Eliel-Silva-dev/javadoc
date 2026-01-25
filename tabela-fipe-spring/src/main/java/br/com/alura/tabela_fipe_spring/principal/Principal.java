package br.com.alura.tabela_fipe_spring.principal;

import br.com.alura.tabela_fipe_spring.model.Data;
import br.com.alura.tabela_fipe_spring.model.Modelos;
import br.com.alura.tabela_fipe_spring.model.Veiculo;
import br.com.alura.tabela_fipe_spring.service.ConsumoApi;
import br.com.alura.tabela_fipe_spring.service.ConverterDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private final Scanner scan = new Scanner(System.in);
    private final ConsumoApi consumo = new ConsumoApi();
    private final ConverterDados conversor = new ConverterDados();

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void showMenu() {
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

        var json = consumo.obterDados(address);
        //System.out.println(json);

        var marcas = conversor.obterLista(json, Data.class);
        marcas.stream().sorted(Comparator.comparing(Data::code))
                .forEach(System.out::println);

        System.out.println("Informe o código da marca para consulta");
        var codigoMarca = scan.nextLine();

        address = address + "/" + codigoMarca + "/modelos";
        json = consumo.obterDados(address);
        var modeloLista = conversor.obterDados(json, Modelos.class);

        System.out.println("Modelos dessa marca: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Data::code))
                .forEach(System.out::println);

        System.out.println("\n Digite um trecho do nome do carro a ser buscado: ");
        var nomeVeiculo = scan.nextLine();

        List<Data> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.name().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos filtrados ");
        modelosFiltrados.forEach(System.out::println);

        


    }
}
