package com.sir.richard.boss.spring.collections.baeldung;

import org.springframework.stereotype.Component;

@Component
public class BaeldungBean {

    private String name;

    public BaeldungBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
