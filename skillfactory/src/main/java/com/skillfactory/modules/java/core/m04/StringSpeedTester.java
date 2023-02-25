package com.skillfactory.modules.java.core.m04;

public class StringSpeedTester {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            //sb.insert(0, "ABC");
            //sb.append(i);
            //sb.insert(1, 100);
            sb.reverse();

        }
        System.out.println((System.currentTimeMillis() - startTime));
    }
}
