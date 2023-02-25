package com.skillfactory.modules.java.core.m02.t251;

public class Loader1 {

    public static void main1(String[] args) {
        int a = 190;
        int b = 245;
        boolean result = true;
        boolean bool = b > a;
        result = a < 167;
        result = bool != result;
        System.out.println(result);
    }

    public static void main2(String[] args) {
        boolean a = false;
        boolean b = 4 < 5;
        boolean c = 3 > 7;

        System.out.println(a && b);
        System.out.println(a || b || c);
        System.out.println(!(a && b && c));
    }

    public static void main3(String[] args) {
        int a = 190 / 5;
        int b = 245 % 17;
        int result = a + b;
        System.out.println(++result);
    }

    public static void main4(String[] args) {
        int a = 10;
        int b = 25;
        int c = 0;

        c = a + b;
        c += a;
        c -= a;
        c *= a;
        c /= a;
        System.out.println(c);
        c %= 13;
        System.out.println(c);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 25;
        int c = 0;
        System.out.println(a + b * 10 >= 255 && 4 << 1 <= 14) ;
    }
}