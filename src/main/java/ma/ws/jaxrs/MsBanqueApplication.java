package ma.ws.jaxrs;

import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.ws.jaxrs.entities.Compte;
import ma.ws.jaxrs.entities.TypeCompte;
import ma.ws.jaxrs.repositories.CompteRepository;

@SpringBootApplication
public class MsBanqueApplication {
  public static void main(String[] args) {
    SpringApplication.run(MsBanqueApplication.class, args);
  }

  @Bean
  CommandLineRunner start(CompteRepository compteRepository){
    return args -> {
      compteRepository.save(new Compte(null, Math.random()*9000, new Date(0), TypeCompte.EPARGNE));
      compteRepository.save(new Compte(null, Math.random()*9000, new Date(0), TypeCompte.COURANT));
      compteRepository.save(new Compte(null, Math.random()*9000, new Date(0   ), TypeCompte.EPARGNE));

      compteRepository.findAll().forEach(c -> {
        System.out.println(c.toString());
      });
    };
  }
}