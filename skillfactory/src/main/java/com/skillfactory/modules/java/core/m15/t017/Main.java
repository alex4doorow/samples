package com.skillfactory.modules.java.core.m15.t017;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Main {

    public static ZonedDateTime getLocalTime(java.util.Date date) {
        Instant instantObject = date.toInstant();
        ZonedDateTime zonedDateTime = instantObject.atZone(ZoneId.of("Europe/Moscow"));
        return zonedDateTime;
    }

    public static void main(String[] args) {

        // Создайте метод, который принимает в качестве аргумента объект java.util.Date и возвращает объект LocalTime, содержащий время переданного объекта в вашем часовом поясе.
        System.out.println(getLocalTime(new Date()));
    }
}
