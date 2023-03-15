package com.skillfactory.modules.java.core.m15.t023;

public class Main {
    public static double doubleFromString(int value, Worker worker) {
        return worker.rework(value);
    }

    public static void main(String[] args) {
        double v = doubleFromString(70, (n) -> {return Double.valueOf(n + 123);});
        System.out.println(v);
    }

    public interface Worker {
        double rework(int value);
    }
}
