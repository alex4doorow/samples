package com.skillfactory.modules.java.core.m15.t054;

import java.util.Optional;

public class OptionalMain {

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty(); // строка 1
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return Optional.of((double) sum / scores.length); // строка 2
    }

    public static void main1(String[] args) {
        Optional<Double> average = average(90, 100);
        if (average.isPresent()) { // проверяем наличие элемента
            System.out.println(average.get()); // 95.0
        }
    }
    public static void main2(String[] args) {
        Optional<Double> average = average(90, 100);
        average.ifPresent(System.out::println); // 95.0
    }
    public static void main3(String[] args) {
        Optional<Double> average = average();
        System.out.println(average.orElse(Double.NaN));
        System.out.println(average.orElseGet(Math::random));
        System.out.println(average.orElseThrow(IllegalStateException::new));
    }

    public static void main4(String[] args) {
        Optional<Double> average = average(90, 100);
        System.out.println(average.orElse(Double.NaN));
        System.out.println(average.orElseGet(Math::random));
        System.out.println(average.orElseThrow(IllegalStateException::new));
    }

    public static void main5(String[] args) {
        average(90, 100).ifPresent(System.out::println); // 95.0
    }

    public static void main(String[] args) {
        main5(args);
    }
}
