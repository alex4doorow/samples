package com.sir.richard.boss.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminal {

    public static void main(String[] args) {

        //Преобразовать поток в List Collectors.toList()
        List<String> collect = Stream.of("a", "b", "c").collect(Collectors.toList());

        //Преобразовать поток в строку String Collectors.joining()
        String collect2 = Stream.of("a", "b", "c").collect(Collectors.joining());

        //Итерация по каждому элементу forEach()
        Stream.of("a", "b", "c").forEach(System.out::println);

        //Узнать количество элементов стрима count()
        Stream.of("a", "b", "c").count();

        //Найти минимальное и максимальное значение min() и max()
        //Сравнение происходит с помощью объекта Comparator.
        //Возвращают объект класса Optional – объект-контейнер, который может хранить null.
        //      Метод get() –  возвращает значение, которое хранит объект Optional.

        Optional<Integer> max = Stream.of(4, 2, 3, 5, 1).max(Comparator.naturalOrder());
        Integer maximum = max.get();

        Integer minimum = Stream.of(4, 2, 3, 5, 1)
                .min(Comparator.naturalOrder())
                .get();

        //Comparator удобно задать с помощью лямбда-функции:
        Stream.of("a", "bb", "ccc")
                .min((s1, s2) -> s1.length() - s2.length())
                .get();

        Stream.of("a", "bb", "ccc")
                .max(Comparator.comparingInt(String::length))
                .get();
        // Найти первый подходящий элемент findFirst()
        // Возвращает первый подходящий элемент из стрима и завершается.
        // Возвращают объект класса Optional.
        Stream.of(1, 2, 3, 4, 5)
                .filter(e -> e % 2 == 0)
                .findFirst()
                .get();

        //Найти любой подходящий элемент findAny()
        //Возвращает любой подходящий элемент из стрима и завершается.
        //Аналог метода findFirst()для потоков, которые обрабатываются параллельно.
        //Найденный элемент не обязательно будет первый по порядку в потоке.

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(e -> e % 2 == 0)
                .parallel()
                .findAny()
                .get();

        // Все элементы соответствуют условию allMatch()
        Stream.of(1, 2, 3, 4, 5).allMatch(e -> e > 0);     // true

        //Все элементы НЕ соответствуют условию noneMatch()
        Stream.of(1, 2, 3, 4, 5).noneMatch(e -> e > 0);    // false

        //Хотя бы один элемент соответствует условию anyMatch()
        Stream.of(1, 2, 3, 4, 5).anyMatch(e -> e > 4);     // true

        //Сумма элементов стрима sum()
        //Это метод классов-стримов примитивных типов данных:
        //IntStream, LongStream и DoubleStream
        List<Integer> integers = new ArrayList<>();

        integers.stream()
                .mapToInt(i -> i)
                .sum();
        //Операция сведения Stream.reduce()
        //Позволяет получить один результат из последовательности элементов, неоднократно применяя операцию комбинирования к элементам в последовательности.

        //        Участники операции сведения:

        //Identity - элемент, который является начальным значением операции сокращения и результатом по умолчанию, если поток пуст.

        //Accumulator - функция, которая принимает два параметра: частичный результат операции сведения и следующий элемент потока

        //Combiner - функция, используемая для объединения частичного результата операции сокращения и типами реализации аккумулятора.
        //Если используем последовательные потоки, типы аргументов аккумулятора и типы его реализации не совпадают – нужно использовать Combiner.

        //        Сумма элементов списка

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        int sum2 = numbers.stream()
                .reduce(0, (subtotal, element) -> subtotal + element);

        //Сумма элементов в параллельном потоке
        //В таких случаях нужно использовать функцию для объединения результатов подпотоков в один – это роль Combiner Комбинатора.
        //В приведенном примере эту роль выполняет метод Integer::sum

        int sum11 = numbers
                .parallelStream()
                .reduce(0, (a, b) -> a + b, Integer::sum);

        List<Integer> ages = new ArrayList<>();
        int sum12 = ages
                .parallelStream()
                .reduce(0, Integer::sum, Integer::sum);
        //Объединение списка строк в одну сроку

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");

        String result = letters.stream()
                .reduce("", String::concat);

        String result2 = letters.stream()
                .reduce("", (partialString, element) -> partialString + element);

        // Optional
        Stream.of("1", "22", "333")
                .max(Comparator.comparingInt(String::length))
                .get();



    }
}
