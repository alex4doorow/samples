package com.skillfactory.modules.java.core.m13.t343;

public class Main extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Thread started");
            throw new InterruptedException("1");
        } catch (InterruptedException exception) {
            System.out.println("Thread interrupted");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Main();
        thread.start();
        thread.interrupt();
    }
}