package com.skillfactory.modules.java.core.m15.t013;

import java.time.Duration;
import java.time.LocalTime;

public class Main {

    private static boolean timeCompare(LocalTime localTime, Duration duration) {
        //Напишите метод, который будет принимать 2 объекта: 1 типа LocalTime и 2 типа Duration, и будет возвращать true, если переданное время + промежуток больше текущего времени.
        LocalTime now = LocalTime.now();
        if (localTime.plus(duration).compareTo(now) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(timeCompare(LocalTime.of(14, 30), Duration.ofMinutes(15)));
        System.out.println(timeCompare(LocalTime.of(22, 30), Duration.ofMinutes(15)));
    }
}
