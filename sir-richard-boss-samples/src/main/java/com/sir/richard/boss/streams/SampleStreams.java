package com.sir.richard.boss.streams;
// https://habr.com/ru/company/otus/blog/658999/

import com.github.javafaker.Faker;
import com.sir.richard.boss.model.animals.Animal;
import com.sir.richard.boss.model.animals.Cat;
import com.sir.richard.boss.model.dto.User;

import java.util.*;
import java.util.stream.Collectors;

public class SampleStreams {

    private final List<User> userList = Arrays.asList(
            new User(1, "Michael", "Robert", 37, "TR"),
            new User(2, "Mary", "Patricia", 11, "EN"),
            new User(3, "John", "Michael", 7, "FR"),
            new User(4, "Jennifer", "Linda", 77, "TR"),
            new User(5, "William", "Elizabeth", 23, "US"),
            new User(6, "Sue", "Jackson", 11, "IT"),
            new User(7, "Michael", "Tommy", 37, "EN")
    );

    private static List<User> generateUsersByFaker(int count) {
        if (count <= 0) {
            return null;
        }
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            User user = new User(i, Faker.instance().name().firstName(), Faker.instance().name().lastName(),
                    Faker.instance().number().numberBetween(18, 52),
                    Faker.instance().nation().capitalCity());
            users.add(user);
        }
        return users;
    }

    public static void main(String... args) {

        SampleStreams sample = new SampleStreams();
        sample.test0();
        sample.test1();
        sample.test2();
        sample.test3();
        sample.test4();
        sample.test6();
        sample.test8();
    }

    private void test0() {
        System.out.println("Test 0");
        System.out.println("Faker users:");
        List<User> users = generateUsersByFaker(101)
                .stream()
                .filter(u -> u.getAge() < 34)
                .filter(u -> u.getFirstName().startsWith("A"))
                .sorted(Comparator.comparing(User::getAge).reversed().thenComparing(User::getFirstName).thenComparing(User::getLastName))
                .toList();

        String stringUsers = users.stream()
                .map(User::toString)
                .collect(Collectors.joining("\n\r"));
        System.out.println(stringUsers);

    }


    private void test1() {
        System.out.println("Test 1");
        userList.forEach(System.out::println);
    }

    private void test2() {
        System.out.println("Test 2");
        userList.stream()
                .map(u -> new User(
                        u.getId(),
                        "X " + u.getFirstName(),
                        "Y " + u.getLastName(),
                        u.getAge() + 10,
                        u.getCapitalCity()))
                .toList()
                .forEach(System.out::println);

        List<Cat> cats = userList.stream().map(u -> new Cat(u.getFirstName())).toList();
        cats.forEach(System.out::println);


    }

    private void test3() {
        System.out.println("Test 3");
        userList.stream()
                .sorted(Comparator.comparing(User::getAge))
                .toList()
                .forEach(System.out::println);
    }

    private void test4() {
        System.out.println("Test 4");
        userList.stream()
                .sorted(Comparator.comparing(User::getAge)
                        .thenComparing(User::getFirstName)
                        .thenComparing(User::getLastName))
                .toList()
                .forEach(System.out::println);
    }

    private void test6() {
        System.out.println("Test 6");
        boolean isAllAgesGreaterThan6 = userList.stream()
                .allMatch(user -> user.getAge() > 6);
        System.out.println("isAllAgesGreaterThan6: " +     isAllAgesGreaterThan6);
    }

    private void test8() {
        System.out.println("Test 8");
        List<User> list = userList.stream()
                .collect(Collectors.toList());
        Set<User> set = userList.stream()
                .collect(Collectors.toSet());
        List<User> linkedList = userList.stream()
                .collect(Collectors.toCollection(LinkedList::new));
        Map<Long, User> map1 = userList.stream()
                .collect(Collectors.toMap(user -> user.getId(), user -> user));
        System.out.println(map1);

        Map<String, User> map2 = userList.stream()
                .collect(Collectors.toMap(user -> user.getLastName(), user -> user));
        System.out.println(map2);
    }

}
