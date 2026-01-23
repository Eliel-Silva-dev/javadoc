package br.com.alura.screenmatch_spring_boot;

import br.com.alura.screenmatch_spring_boot.principal.Principal;
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

        Principal principal = new Principal();
        principal.showMenu();
    }
}
