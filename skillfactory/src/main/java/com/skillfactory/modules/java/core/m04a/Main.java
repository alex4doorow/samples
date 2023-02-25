package com.skillfactory.modules.java.core.m04a;

public class Main {
    public static void main(String[] args) {
        Balance balance = new Balance();
        balance.addLeft(100);
        balance.addRight(100);

        System.out.println(balance.getSituation());
    }
}