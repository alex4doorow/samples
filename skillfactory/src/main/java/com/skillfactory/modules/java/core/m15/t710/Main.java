package com.skillfactory.modules.java.core.m15.t710;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, Month.JUNE, 21);
        LocalDate.of(2014, 6, 21);
        System.out.println(date);
    }
}
