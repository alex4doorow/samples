package com.skillfactory.modules.java.core.m15.t720;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> stream = Stream.iterate("", (s) -> s + "1");
        System.out.println(stream.limit(2).map(x -> x + "2").toList());
        //System.out.println(stream.limit(2).map(x -> x + "2"));
    }
}
