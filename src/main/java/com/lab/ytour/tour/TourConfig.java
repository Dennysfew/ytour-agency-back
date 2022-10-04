package com.lab.ytour.tour;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TourConfig {

    @Bean
    CommandLineRunner commandLineRunner(TourRepository repository) {
        return args -> {
            Tour carpaty = new Tour(
                    "Amazing Ukraine discover",
                    "Ukraine",
                    150,
                    "https://cdn.theculturetrip.com/wp-content/uploads/2018/01/_05.jpg"
            );

            Tour lviv = new Tour(
                    "Amazing Ukraine city Lviv discover",
                    "Ukraine",
                    50,
                    "https://www.washingtonpost.com/resizer/Q3gSZn4URJz_lw1lkyPaUhzjPkY=/arc-anglerfish-washpost-prod-washpost/public/DBLLHPDG5AI6TJUYFKHYBDE47M.jpg"
            );
        repository.saveAll(List.of(carpaty, lviv));
        };
    }
}
