package com.sir.richard.boss.lambda;

import com.sir.richard.boss.model.dto.User;

public class AnotherMain4Lambda {

    public Integer analyzeUser(Integer i, User u, ObjectAnalyzeFunction<Integer, User> function) {
        return function.toAnalyze(i, u);
    }

    public static void main(String[] args) {

        AnotherMain4Lambda main = new AnotherMain4Lambda();
        User user = new User(1, "Michael", "Robert", 37, "TR");
        System.out.println(main.analyzeUser(15, user, (i, u) -> user.getAge() + i));
        System.out.println(main.analyzeUser(15, user, (i, u) -> user.getAge() - i));

        Runnable runnable = () -> System.out.println("Hello world two!");

    }
}
