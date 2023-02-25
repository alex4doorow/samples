package com.sir.richard.boss.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectors {
    public static void main(String[] args) {
        List<String> list1 = Stream.of("a", "b", "c").collect(Collectors.toList());

        list1.stream().collect(Collectors.toList());
        Set<String> set1 = list1.stream().collect(Collectors.toSet());

        Map<String, String> map = new HashMap<>();
        map.put("1", "One");
        map.put("2", "Two");
        map.put("3", "Three");

        map.entrySet().stream()
                .map(e -> String.valueOf(e).split("="))
                .collect(Collectors.toMap(e -> e[0], e -> e[1]));
        System.out.println(map);

        String s = list1.stream().collect(Collectors.joining(","));
        System.out.println(list1 + ": " + s);
    }
}
