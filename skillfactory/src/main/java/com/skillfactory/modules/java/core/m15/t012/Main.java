package com.skillfactory.modules.java.core.m15.t012;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2009, 4, 22);
        Period period = Period.ofYears(4);
        System.out.println(date.minus(period)); // 2005-4-22
        LocalTime time = LocalTime.of(16, 30);
        Duration duration = Duration.ofMinutes(15);
        System.out.println(time.plus(duration)); // 16:45
    }
}
