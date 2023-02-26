package com.sir.richard.boss.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class Main4Lambda {
    // https://habr.com/ru/post/693666/
    // database jpa examples https://habr.com/ru/post/684912/

    public Integer processTwoNumbers(Integer a, Integer b, ToIntBiFunction<Integer, Integer> function) {
        return function.applyAsInt(a, b);
    }

    public static void main(String[] args) {
        Main4Lambda main = new Main4Lambda();
        // 1
        Integer result = main.processTwoNumbers(11, 12, new ToIntBiFunction<>() {
            @Override
            public int applyAsInt(Integer a, Integer b) {
                log.info("a: {}, b: {}", a, b);
                return a + b;
            }
        });
        System.out.println(result);
        // 2
        ToIntBiFunction<Integer, Integer> biFunction = (a, b) -> a * b;
        // 3
        result = main.processTwoNumbers(21, 34, biFunction);
        System.out.println(result);
        // 4
        result = main.processTwoNumbers(11, 12, (a, b) -> a - b);
        System.out.println(result);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        //integers.forEach(item -> System.out.println(item));
        integers.forEach(System.out::println);
        integers.forEach(item -> log.info("item: {}", item));

        List<String> colors = Arrays.asList("Black", "White", "Red");
        Collections.sort(colors, (o1, o2) -> {
            String o1LastLetter = o1.substring(o1.length() - 1);
            String o2LastLetter = o2.substring(o2.length() - 1);
            return o1LastLetter.compareTo(o2LastLetter);
        });


    }


}
