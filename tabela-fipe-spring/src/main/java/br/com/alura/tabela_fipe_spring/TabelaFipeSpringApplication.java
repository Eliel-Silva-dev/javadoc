package br.com.alura.tabela_fipe_spring;

import br.com.alura.tabela_fipe_spring.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TabelaFipeSpringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TabelaFipeSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.showMenu();
    }
}
