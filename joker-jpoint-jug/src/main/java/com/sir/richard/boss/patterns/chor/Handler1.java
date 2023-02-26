package com.sir.richard.boss.patterns.chor;

import org.springframework.stereotype.Component;

@Component
public class Handler1 implements Handler {
    @Override
    public void handle(DataObject t) {
        System.out.println("Handler1.handle");

    }
}
