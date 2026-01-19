package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.exceptions.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.model.Title;
import br.com.alura.screenmatch.model.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um filme para a busca: ");
        var search = scan.nextLine();

        var endereco = "https://www.omdbapi.com/?t=" + search + "&apikey=49749daf";

        try {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                        .create();
        TituloOmdb myTitleOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(myTitleOmdb);

        Title myTitle = new Title(myTitleOmdb);
        System.out.println("Titulo já convertido: ");
        System.out.println(myTitle);

        } catch (NumberFormatException e) {

            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println("Algum erro de argumento na busca ");

        } catch (ErroDeConversaoDeAnoException e) {

            System.out.println(e.getMessage());
        }

        System.out.println("Sistema finalizou com sucesso...");

    }
}
