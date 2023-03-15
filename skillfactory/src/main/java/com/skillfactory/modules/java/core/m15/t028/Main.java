package com.skillfactory.modules.java.core.m15.t028;

import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        BiFunction<String, String, Integer> biFunction = String::indexOf;
        BiPredicate<String, String> biPredicate = String::contains;
        Supplier<String> supplier = String::new;
        Function<String, Integer> function = Integer::valueOf;
        Consumer<List<Double>> consumer = Collections::sort;

    }
}
