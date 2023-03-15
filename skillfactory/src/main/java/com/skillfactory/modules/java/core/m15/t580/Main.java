package com.skillfactory.modules.java.core.m15.t580;

import java.util.List;

public class Main {
    //Необходимо список строк перевести в список чисел и произвести их умножение.
    // Решите задачу, сначала используя обычный подход, а затем попробуйте написать тот же код на стримах.


    public static void main(String[] args) {
        List<String> numbers = List.of("1", "2", "3");
        final int result = 1;
        long i = numbers.stream()
                .map(Integer::valueOf)
                .reduce(1, (a, b) -> a * b)
                .longValue();
        System.out.println(i);
    }
}
