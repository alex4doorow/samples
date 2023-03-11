package com.skillfactory.modules.java.core.m14.t031.v2;

class Typer extends Thread {
    // неправильно!

    private String message;

    public Typer(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        customRun();
    }

    private synchronized void customRun() {
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
