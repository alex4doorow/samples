package com.sir.richard.boss.spring.collections.solid.processor.impl;

import com.sir.richard.boss.spring.collections.solid.processor.CheckingDbUpdaterProcessor;
import org.springframework.stereotype.Component;

public class CheckingForCreateDbUpdaterProcessor implements CheckingDbUpdaterProcessor {
    private String name;

    public CheckingForCreateDbUpdaterProcessor(String name) {
        this.name = name;
    }

    public CheckingForCreateDbUpdaterProcessor() {
        this.name = "unknown creator";
    }

    @Override
    public void process() {
        System.out.println(this.getClass().toString());
    }

    @Override
    public String toString() {
        return "{" + this.getClass().toString() + ": 'name='" + name + "'}";
    }
}