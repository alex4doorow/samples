package com.skillfactory.modules.java.core.m06.l04.l3;

public class SubClass2 extends  SuperClass2 {

    SubClass2(int a) {
        super(a);
    }

    @Override
    public int add(int v) {
        return super.add(v) + a;
    }

    @Override
    public int sub(int v) {
        return b - super.sub(v);
    }

}
