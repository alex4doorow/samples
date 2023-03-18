package com.sir.richard.boss.services.loaders;

import com.sir.richard.boss.bl.entity.Coffee;
import com.sir.richard.boss.bl.jpa.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class CoffeeDataLoader {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @PostConstruct
    public void init() {

        this.coffeeRepository.saveAll(List.of(
                new Coffee("Café Cereza"),
                new Coffee("Café Ganador"),
                new Coffee("Café Lareño"),
                new Coffee("Café Três Pontas")
        ));
    }



}
