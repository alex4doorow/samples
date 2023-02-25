package com.skillfactory.modules.java.core.m06.l04.l1;

public class SubClass extends SuperClass {
    SubClass(int a, int b) {
        super(a);
        this.b = b;
    }

    @Override
    public int add(int v) {
        return super.add(v) + a;
    }

    public static void main(String args[]) {
        SubClass s = new SubClass(10, 12);
        //System.out.println(s.a);
        System.out.println(s.add(10));
    }
}
