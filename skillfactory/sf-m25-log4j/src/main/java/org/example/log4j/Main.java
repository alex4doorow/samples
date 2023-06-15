package org.example.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Это информационное сообщение!");
        log.error("Это сообщение ошибки");
    }
}