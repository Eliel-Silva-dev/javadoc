import model.Address;
import service.GeneratorFile;
import service.SearchAddress;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SearchAddress searchAddress = new SearchAddress();

        System.out.println("Digite um número de CEP para consulta:");
        var cep = scan.nextLine();

        try {
            Address newAddress = searchAddress.searchCep(cep);
            System.out.println(newAddress);

            GeneratorFile generatorFile = new GeneratorFile();
            generatorFile.saveJson(newAddress);

        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }
    }
}
