package com.skillfactory.modules.java.gradle;

import com.google.common.collect.Lists;
import hello.Greeter;
import org.joda.time.LocalTime;

import java.util.List;

public class App {

    public static void main(String[] args) {
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);

        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
        System.out.println(getGreeting());
    }

    public static String getGreeting() {
        List<String> greeting = Lists.newArrayList("Hello", "World", "!");
        return greeting.toString();
    }
}
