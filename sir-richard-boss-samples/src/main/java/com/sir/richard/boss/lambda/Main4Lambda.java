package com.sir.richard.boss.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class Main4Lambda {

    public void processTwoNumbers(Integer a, Integer b, ToIntBiFunction<Integer, Integer> function) {
        function.applyAsInt(a, b);
    }

    public static void main(String[] args) {
        Main4Lambda main = new Main4Lambda();
        main.processTwoNumbers(11, 12, new ToIntBiFunction<>() {
            @Override
            public int applyAsInt(Integer a, Integer b) {
                log.info("a: {}, b: {}", a, b);
                return a + b;
            }
        });
        ToIntBiFunction<Integer, Integer> biFunction = (a, b) -> a + b;
        main.processTwoNumbers(11, 12, (a, b) -> a + b);

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
