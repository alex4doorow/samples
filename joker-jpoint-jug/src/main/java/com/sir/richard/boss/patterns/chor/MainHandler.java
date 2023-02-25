package com.sir.richard.boss.patterns.chor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainHandler {

    // chain of responsibility

    @Autowired
    private List<Handler> handlers;

    public void handle(DataObject t) {
        System.out.println("MainHandler.handle");
        handlers.forEach(handler -> handler.handle(t));
    }
}