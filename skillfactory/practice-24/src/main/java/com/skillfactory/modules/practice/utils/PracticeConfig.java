package com.skillfactory.modules.practice.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class PracticeConfig {

    public static final String DIST = "c:/src/--1-skillfactory/java/samples/skillfactory/practice-24/results/";

    public static void distCreateIfNotExist() {
        if (Files.notExists(Paths.get(PracticeConfig.DIST))) {
            try {
                Files.createDirectory(Paths.get(PracticeConfig.DIST));
                log.info("Directory created successfully");
            } catch (IOException ioEx) {
                log.error("IOException:", ioEx);
            }
        }
    }
}
