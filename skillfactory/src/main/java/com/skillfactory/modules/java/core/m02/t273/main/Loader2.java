package com.skillfactory.modules.java.core.m02.t273.main;

public class Loader2 {

    public static void main1(String[] args) {
        int x = 15;

        if (x == 10) {
            System.out.print("x = 10");
        } else if (x == 20) {
            System.out.print("x = 20");
        } else {
            System.out.print("Подходящего условия нет!");
        }
    }

    public static void main2(String[] args) {
        int sum = 10;
        for (int i = 10; i < 100; i = i + 10) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int i = 45;
        while (i < 350) {
            i++;
        }
        System.out.println("Value i = " + i);
    }
}