package com.sir.richard.boss.model.animals;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dog extends Mammal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public String voice() {
        String result = "Wuff! Wuff!";
        log.info(result);
        return result;
    }

    @Override
    public String toString() {
        return "Dog {name='" + getName() + "'}";
    }
}
