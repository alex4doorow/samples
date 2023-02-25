package com.skillfactory.modules.java.core.hw02.hw0205;

public class Teacher extends People {
    private final String subject;

    public Teacher(String name, int age, String profession, String subject) {
        super(name, age, profession);
        this.subject = subject;
    }

    @Override
    public String getProfession() {
        return profession;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public String getSubject() {
        return this.subject;
    }

    public String giveALesson() {
        return "The lesson was ended";
    }
}
