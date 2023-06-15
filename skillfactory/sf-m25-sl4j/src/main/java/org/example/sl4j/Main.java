package org.example.sl4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Это информационное сообщение!");
        log.error("Это сообщение ошибки");

    }
}