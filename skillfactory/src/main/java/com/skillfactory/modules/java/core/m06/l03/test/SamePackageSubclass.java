package com.skillfactory.modules.java.core.m06.l03.test;

public class SamePackageSubclass extends BaseClass {
    public SamePackageSubclass() {
        this.defaultValue = 3;
        this.protectedValue = 3;
        BaseClass a = new BaseClass();
        a.defaultValue = 3;
        a.protectedValue = 3;
    }
}