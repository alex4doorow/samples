package com.skillfactory.modules.java.core.m06.l03.test;

public class SamePackageAccess {
    public SamePackageAccess() {
        BaseClass a = new BaseClass();
        a.defaultValue = 2;
        a.protectedValue = 2;
    }
}
