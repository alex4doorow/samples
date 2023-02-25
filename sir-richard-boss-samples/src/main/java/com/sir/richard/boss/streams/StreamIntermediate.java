package com.sir.richard.boss.streams;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamIntermediate {
    public static void main(String[] args) {
        System.out.println("1");
        Stream.of("a", "b", "c").peek(System.out::println);

        // Преобразовать данные из одного типа в другой map()
        Stream.of(1, 2, 3).map((x) -> String.valueOf(x));

        Stream.of(1, 2, 3).map(String::valueOf);        // лямбда выражение

        Stream.of("1", "2", "3").map(Integer::parseInt);

        //Отфильтровать элементы filter()
        Stream.of(1, 2, 3, 4, 5).filter(n -> n < 4);    // [1, 2, 3]

        //Удалить дублирующиеся элементы distinct()
        Stream.of(1, 2, 3, 2, 4, 2, 5).distinct();      // [1, 2, 3, 4, 5]

        //Сортировка и обратная сортировка элементов sorted()
        Stream.of(4, 2, 3, 5, 1).sorted();              // [1, 2, 3, 4, 5]

        Stream.of(4, 2, 3, 5, 1).sorted(Comparator.reverseOrder());

        //Лимит количества элементов limit()
        Stream.of(1, 2, 3, 4, 5, 6).limit(3);            // [1, 2, 3]

        //Пропустить первые элементы skip()
        Stream.of(1, 2, 3, 4, 5).skip(2);                // [3, 4, 5]




    }



}
