package com.skillfactory.modules.java.core.m02.t234;

public class Loader3 {
    public static void main1(String[] args) {
        int value = add(3, 4);
        int result = add(value, 10);
        System.out.println(result);
    }
    public static void main(String[] args) {
        String str = "String #1";
        String Str = "String #2";
        String sTr = "String #3";
        String StR = "String #4";
        str = sTr;
        System.out.println(str);
        byte b1 = 120;
        byte b2 = 8;
        System.out.println(b1 + b2);
    }

    public static int add(int x, int y) {
        int result = x + y;
        return result;
    }
}