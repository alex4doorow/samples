package com.skillfactory.modules.java.core.m11.t41;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
    public static String someMethod() {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            return "catch";
        } finally {
            return "finally";
        }
    }

    public static void main(String[] args) {
        System.out.println(someMethod());
    }
}
