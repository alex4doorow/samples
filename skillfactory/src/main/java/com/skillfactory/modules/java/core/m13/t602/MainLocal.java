package com.skillfactory.modules.java.core.m13.t602;

import com.skillfactory.modules.java.core.m13.t34.JoinExample1;

public class MainLocal {
    private static int counter = 0;

    public static void main(String[] args) {

        try {
            LoadingThread t = new LoadingThread();
            t.start();
            t.join();
        } catch (InterruptedException e) {
        }
        System.out.println("Images are loaded");
    }
}
