package com.sir.richard.boss.streams;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamInit {
    public static void main(String[] args) {
        // #1
        List<String> list = new ArrayList<>();

        list.stream();

        list.parallelStream();


        // #2
        Map<String, String> map = new HashMap<>();

        map.entrySet().stream();

        map.values().stream();


        // #3
        String[] array = new String[10];

        Stream<String> stream2 = Arrays.stream(array);

        // #4
        Stream<String> stream1 = Stream.of("a", "b", "c");        // поток из элементов

        Stream.of(array);                // поток из элементов массива

        Stream.of(list);                 // поток из элементов списка List

        Stream.generate(Math::random);   // генерация потока рандомных чисел

        Stream.concat(stream1, stream2); // объединяет два потока в один

        IntStream.range(1, 10);          // поток диапазона чисел от 1 до 9

        IntStream.rangeClosed(1, 10);    // поток диапазона чисел от 1 до 10
    }
}
