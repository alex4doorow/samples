package com.skillfactory.webinars.w12.streams;

import java.util.ArrayList;
import java.util.List;

public class LambdaMain {
    public static void main(String[] args) {

        User u1 = new User("one", 11);
        User u2 = new User("two", 31);
        User u3 = new User("three", 51);

        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.stream().filter(user -> user.getAge() > 20).forEach(System.out::println);

    }
}
