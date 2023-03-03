package com.sir.richard.boss.spring.collections.solid.processor.impl;

import com.sir.richard.boss.spring.collections.solid.processor.CheckingDbUpdaterProcessor;
import org.springframework.stereotype.Component;

public class CheckingForUpdateDbUpdaterProcessor implements CheckingDbUpdaterProcessor {

    private String name;

    public CheckingForUpdateDbUpdaterProcessor(String name) {
        this.name = name;
    }

    @Override
    public void process() {
        System.out.println(this.getClass().toString());
    }

    public String toString() {
        return "{" + this.getClass().toString() + ": 'name='" + name + "'}\n\r";
    }
}
