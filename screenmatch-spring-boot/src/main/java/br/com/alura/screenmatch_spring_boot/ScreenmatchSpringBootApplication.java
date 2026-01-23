package br.com.alura.screenmatch_spring_boot;

import br.com.alura.screenmatch_spring_boot.model.DadosSerie;
import br.com.alura.screenmatch_spring_boot.service.ConsumoDeApi;
import br.com.alura.screenmatch_spring_boot.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchSpringBootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var consumoApi = new ConsumoDeApi();
        var json = consumoApi.obtemDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=49749daf");

        System.out.println(json);

        ConverteDados converter = new ConverteDados();

        DadosSerie data = converter.obterDados(json, DadosSerie.class);

        System.out.println(data);
    }
}
