package com.skillfactory.modules.java.core.m03;

public class Example1 {
    public static void main(String[] args) {
        int[] array = {13, 32, 39, 4, 55, 36, 7, 82, 99, 10};
        int[] copy = array;
        for (int i = 0; i < copy.length; i++) {
            copy[i] = copy[i] * 2;
        }
        System.out.println(copy[3]);
    }
}
