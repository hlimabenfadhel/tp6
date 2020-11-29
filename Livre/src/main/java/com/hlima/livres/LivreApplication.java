package com.hlima.livres;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.hlima.livres.entities.Livre;
import com.hlima.livres.service.LivreService;

@SpringBootApplication
public class LivreApplication implements CommandLineRunner {
@Autowired
private RepositoryRestConfiguration repositoryRestConfiguration;
public static void main(String[] args) {
SpringApplication.run(LivreApplication.class, args);
}
@Override
public void run(String... args) throws Exception {
repositoryRestConfiguration.exposeIdsFor(Livre.class);
}

}