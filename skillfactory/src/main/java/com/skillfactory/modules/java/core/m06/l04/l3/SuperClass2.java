package com.skillfactory.modules.java.core.m06.l04.l3;

public class SuperClass2 {
    public int a;
    public int b;

    SuperClass2(int a) {
        this.a = 15;
        this.b = 33;
    }

    public int add(int v) {
        return a + v;
    }

    public int sub(int v) {
        return b - v;
    }

    public final void doSmth() {
        System.out.println("Do smth!");
    }
}
