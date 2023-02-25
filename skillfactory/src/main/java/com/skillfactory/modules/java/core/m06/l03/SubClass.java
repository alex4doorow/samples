package com.skillfactory.modules.java.core.m06.l03;

public class SubClass extends SuperClass {
    int num = 77;

    SubClass(int a) {
        super(a);
    }

    // Метод display() подкласса
    public void display() {
        System.out.println("Это метод display() подкласса");
    }

    public void myMethod() {
        // Вызываем метод display() подкласса
        this.display();

        // Вызываем метод display() суперкласса
        //super.display();

        // Выводим значение переменной num подкласса
        System.out.println("Значение переменной num в подклассе: " + this.num);

        // Выводим значение переменной num суперкласса
        //System.out.println("Значение переменной num в суперклассе: " + super.num);
    }

    public static void main(String args[]) {
        //SubClass obj = new SubClass();
        //obj.myMethod();
    }
}

