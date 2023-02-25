package com.skillfactory.modules.java.core.m04;

public class Tank1 {
    private int positionX = 0;

    public void goForward(int step) {
        positionX += step;
    }

    public void goBackward(int step) {
        positionX -= step;
    }

    public void printPosition() {
        System.out.println("The Tank is at " + positionX + " now");
    }
}
