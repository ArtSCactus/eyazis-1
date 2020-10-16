package org.none.searchapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SearchApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchApiApplication.class, args);
    }

    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger("application");
    }
}
