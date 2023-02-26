package com.sir.richard.boss.model.animals;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Cat extends Mammal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String voice() {
        String result = "May!";
        log.info(result);
        return result;
    }

    @Override
    public String toString() {
        return "Cat {name='" + getName() + "'}";
    }
}
