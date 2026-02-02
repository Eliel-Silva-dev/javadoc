package br.com.alura.screenmatch_spring_boot;

import br.com.alura.screenmatch_spring_boot.principal.Principal;
import br.com.alura.screenmatch_spring_boot.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchSpringBootApplication.class, args);
    }

}
