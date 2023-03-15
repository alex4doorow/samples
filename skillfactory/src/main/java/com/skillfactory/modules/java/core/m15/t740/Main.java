package com.skillfactory.modules.java.core.m15.t740;

import java.util.OptionalLong;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        LongStream ls = LongStream.of(1, 2, 3);
        OptionalLong opt = ls.map(n -> n * 10).filter(n -> n < 5).findFirst();
        //if (opt.isPresent()) System.out.println(opt.get());
        if (opt.isPresent()) System.out.println(opt.getAsLong());
        //opt.ifPresent(System.out.println);
        opt.ifPresent(System.out::println);


    }
}
