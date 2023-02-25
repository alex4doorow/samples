package com.skillfactory.modules.java.core.m06.l03;

public class SuperClass {
    public int a;
    public int b;

    SuperClass(int a) {
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

