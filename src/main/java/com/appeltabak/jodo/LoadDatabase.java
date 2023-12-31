package com.appeltabak.jodo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDataBase(TodoRepository repo) {
        return args -> {
            logger.info("Preloading " + repo.save(new TodoResource("WC schoonmaken")));
            logger.info("Preloading " + repo.save(new TodoResource("Keuken opruimen")));
        };
    }
}
