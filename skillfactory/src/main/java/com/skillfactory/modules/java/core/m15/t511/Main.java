package com.skillfactory.modules.java.core.m15.t511;

import java.util.stream.IntStream;

public class Main {
    //Сгенерируйте последовательность чисел от 1 до 100 включительно, ограничьте ее последними 50 числами,
    // оставьте только те числа, которые делятся без остатка на 2 или на 5, и посчитайте сумму полученных чисел.
    // В ответе у вас должно выйти 2275
    public static void main(String[] args) {
        //List<Integer> numbers =  IntStream.range(0, 100).limit(50).peek(System.out::println)
        int sum = IntStream.rangeClosed(0, 100)
                .skip(51)
                .peek(System.out::println)
                .filter(n -> n % 2 == 0 || n % 5 == 0)
                .sum();
        System.out.println(sum);
    }
}
