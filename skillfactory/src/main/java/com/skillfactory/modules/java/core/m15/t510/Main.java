package com.skillfactory.modules.java.core.m15.t510;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Double> list = Arrays.asList(117d, 12.2d, 66d, 18.5d);
        List<String> list2 = Arrays.asList("15", "18.5", "117", "22.2");
        List<Double> doubles = new ArrayList<>();
        for (String s : list2) {
            doubles.add(Double.valueOf(s));
        }
        Set<Double> sortedDoubles = new TreeSet<>(Comparator.reverseOrder());
        sortedDoubles.addAll(list);
        sortedDoubles.addAll(doubles);
        for (double d : sortedDoubles) {
            System.out.println(d);
        }
        System.out.println(":");
        main1(args);
    }

    public static void main1(String[] args) {
        List<Double> list = List.of(117d, 12.2d, 66d, 18.5d);
        List<String> list2 = List.of("15", "18.5", "117", "22.2");

        List<Double> sortedDoubles = list2.stream()
                .map(Double::valueOf)
                .collect(Collectors.toList());

        //Stream.of(list, sortedDoubles)
       Stream.concat(list.stream(), sortedDoubles.stream())
                .collect(Collectors.toCollection(TreeSet::new))
                .stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);


    }
}
