package com.skillfactory.modules.java.core.m04a;

public class Human {
    String name, address, work;
    int age, weight;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 60;
    }

    public Human(String name, String address) {
        this.name = name;
        this.address = address;
        this.weight = 60;
        this.age = 25;
    }

    public Human(String name, int age, int weight) {
        this(name, age);
        this.weight = weight;
    }

    public Human(String name, int age, String work) {
        this(name, age);
        this.weight = 60;
        this.work = work;
    }

    public Human(int age, int weight, String address, String work) {
        this.name = "Jhon";
        this.age = age;
        this.weight = weight;
        this.address = address;
        this.work = work;
    }
}