package com.skillfactory.modules.java.core.m13.t34;

public class CheckResults2 {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(CheckResults2::calculateCounter).start();


        int i = 0;
        while (CheckResults2.counter < 100) {
            //System.out.println("Not reached yet");
            Thread.sleep(2);
            i++;
        }
        System.out.println("Reached: " + i);
    }

    private static void calculateCounter() {
        for (int i = 0; i < 100; i++) {
            CheckResults2.counter++;
        }
    }

}