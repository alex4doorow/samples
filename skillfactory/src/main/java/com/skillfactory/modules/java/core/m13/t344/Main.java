package com.skillfactory.modules.java.core.m13.t344;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        ConsoleClock cc = new ConsoleClock();
        cc.start();
        Thread.sleep(3000);
        cc.interrupt();
    }

}
