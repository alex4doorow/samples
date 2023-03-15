package com.skillfactory.modules.java.core.m15.t640;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        String prevValue = "";
        for (int i = 1; i < 10; i++) {
            String value = prevValue + String.valueOf(i);
            lines.add(value);
            prevValue = value;

        }
        System.out.println(lines);
        Path path2 = Paths.get("c:\\src\\--1-skillfactory\\java\\samples\\skillfactory\\src\\main\\java\\com\\skillfactory\\modules\\java\\core\\m15\\t640\\test2.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path2, Charset.defaultCharset())) {
            lines.forEach(line -> {
                try {
                    writer.write(line);
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            // Handle file I/O exception
        }
        System.out.println(".");
        //Теперь запишите содержимое этого файла в другой файл со строками, записанными в обратном порядке.

        List<String> lines2 = lines.stream().sorted((d1, d2) -> {
            return d2.compareTo(d1);
        }).toList();
        System.out.println(lines2);

        Path path3 = Paths.get("c:\\src\\--1-skillfactory\\java\\samples\\skillfactory\\src\\main\\java\\com\\skillfactory\\modules\\java\\core\\m15\\t640\\test3.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path3, Charset.defaultCharset())) {
            lines2.forEach(line -> {
                try {
                    //System.out.println(line);
                    writer.write(line);
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            // Handle file I/O exception
        }


        //Set<String> lines2 = lines.stream().sorted(Comparator.reverseOrder()).peek(System.out::println).collect(Collectors.toCollection(TreeSet::new));
    }
}
