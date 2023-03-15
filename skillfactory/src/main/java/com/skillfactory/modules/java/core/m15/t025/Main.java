package com.skillfactory.modules.java.core.m15.t025;

import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        task1("ss", "sd", (value1, value2) -> value1.endsWith(value2));

        task1("ss", "sd", String::endsWith);
    }

    private static void task1(String s1, String s2, BiPredicate<String, String> param) {
        param.test(s1, s2);
    } // вставьте тип

    public static void main2(String[] args) {
        task2(() -> 65.7);
    }

    private static void task2(Supplier<Double> param) {} // вставьте тип
}
