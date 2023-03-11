package com.skillfactory.modules.java.core.m14.t031.v1;

class Typer extends Thread {
    static Object lock = new Object();
    private String message;

    public Typer(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < message.length(); i++) {
                System.out.print(message.charAt(i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
