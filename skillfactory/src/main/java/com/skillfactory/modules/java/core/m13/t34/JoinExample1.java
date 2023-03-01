package com.skillfactory.modules.java.core.m13.t34;

public class JoinExample1 {

    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 50000000; i++) {
                JoinExample1.counter++;
            }
        });
        thread.start();
        thread.join();

        System.out.println("Counter value: " + counter); // Counter value: 0
    }

}
