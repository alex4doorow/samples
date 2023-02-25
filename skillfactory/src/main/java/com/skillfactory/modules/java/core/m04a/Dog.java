package com.skillfactory.modules.java.core.m04a;

public class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String bark() {
        return "woof";
    }

    // name getter and setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // age getter and setter
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}