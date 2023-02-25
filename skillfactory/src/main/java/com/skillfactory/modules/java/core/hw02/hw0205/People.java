package com.skillfactory.modules.java.core.hw02.hw0205;

public abstract class People {

    protected String name;

    protected int age;
    protected String profession;

    public People(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    public abstract String getProfession();
    public abstract String getName();
    public abstract int getAge();

}
