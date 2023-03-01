package com.skillfactory.modules.java.core.m13.t34;

public class CheckResults1 {
    private static int counter = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                CheckResults1.counter++;
            }
        }).start();

/*
        new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    CheckResults.counter++;
                }
            }
        }.start();

 */
        int i = 0;
        while (CheckResults1.counter < 100) {
            //System.out.println("Not reached yet");
            i++;
        }
        System.out.println("Reached: " + i);
    }

}