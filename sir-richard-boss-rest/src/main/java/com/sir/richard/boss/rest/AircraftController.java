package com.sir.richard.boss.rest;

import com.sir.richard.boss.bl.entity.Aircraft;
import com.sir.richard.boss.bl.entity.Coffee;
import com.sir.richard.boss.bl.jpa.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/aircrafts")
public class AircraftController {

    @Autowired
    private AircraftRepository aircraftRepository;

    @GetMapping
    Iterable<Aircraft> getAircrafts() {
        return aircraftRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Aircraft> getAircraftById(@PathVariable Long id) {
        return aircraftRepository.findById(id);
    }


}
