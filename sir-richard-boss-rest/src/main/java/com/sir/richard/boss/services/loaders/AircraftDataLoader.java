package com.sir.richard.boss.services.loaders;

import com.sir.richard.boss.bl.entity.Aircraft;
import com.sir.richard.boss.bl.jpa.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.Optional;

@Component
public class AircraftDataLoader {

    @Autowired
    private AircraftRepository aircraftRepository;

    @PostConstruct
    public void init() {


        Optional<Aircraft> aircraft = aircraftRepository.findById(81L);

        if (aircraft.isPresent()) {
            aircraftRepository.deleteById(81L);
        }
        aircraftRepository.save(new Aircraft(81L,
                "AAL608", "1451", "N754UW", "AA608", "IND-PHX", "A319", "A3",
                36000, 255, 423, 0, 36000,
                39.150284, -90.684795, 1012.8, 26.575562, 295.501994,
                true, false,
                Instant.parse("2020-11-27T21:29:35Z"),
                Instant.parse("2020-11-27T21:29:34Z"),
                Instant.parse("2020-11-27T21:29:27Z")));

    }



}
