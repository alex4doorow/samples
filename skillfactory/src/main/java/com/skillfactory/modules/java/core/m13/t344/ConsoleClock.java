package com.skillfactory.modules.java.core.m13.t344;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class ConsoleClock extends Thread {
    // write class which print time as HH:MM:SS
    // every second here
    public void run() {
        while (true) {
            try {
                LocalDateTime localDateTime = LocalDateTime.now();
                String formattedTime = localDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                System.out.println(formattedTime);
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("The clock was stopped");
                break;
            }
        }
    }
}
