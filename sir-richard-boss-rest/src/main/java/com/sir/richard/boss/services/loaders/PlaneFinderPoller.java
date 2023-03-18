package com.sir.richard.boss.services.loaders;

import com.sir.richard.boss.bl.entity.Aircraft;
import com.sir.richard.boss.bl.jpa.AircraftRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@Component
class PlaneFinderPoller {
    @Autowired
    private AircraftRepository repository;
    private WebClient client = WebClient.create("localhost:7634/aircraft");

    @Scheduled(fixedRate = 1000)
    private void pollPlanes() {
        //repository.deleteAll();

        client.get()
                .retrieve()
                .bodyToFlux(Aircraft.class)
                .toStream()
                //.forEach(repository::save);
                .forEach(System.out::println);


/*
        client.get()
                .retrieve()
                .bodyToFlux(Aircraft.class)
                .filter(plane -> !plane.getReg().isEmpty())
                .toStream()
                .forEach(repository::save);

 */

        //repository.findAll().forEach(System.out::println);
    }
}
