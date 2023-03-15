package com.skillfactory.modules.java.core.m15.t570;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.iterate(1, integer -> integer + 1);
        boolean match = stream
                .map(String::valueOf)
                .distinct()
                .limit(5)
                .noneMatch(str -> str.length() != 1);
        System.out.println(match);
    }
}
