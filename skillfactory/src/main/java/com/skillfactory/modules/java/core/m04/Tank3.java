package com.skillfactory.modules.java.core.m04;

public class Tank3 {
    private int positionX = 0;
    private int positionY = 0;
    private int fuel;
    private boolean isX = true;

    public Tank3(int x, int y, int fuel) {
        this.positionX = x;
        this.positionY = y;
        this.fuel = fuel;
    }

    public Tank3(int x, int y) {
        this(x, y, 100);
    }

    public Tank3() {
        this(0, 0, 100);
    }

    public void goForward(int step) {
        if (fuel - step < 0) {
            System.out.println("Fuel's tank is empty");
            return;
        }
        if (isX) {
            positionX += step;
        } else {
            positionY += step;
        }
        fuel -= step;
    }

    public void goBackward(int step) {
        if (fuel - step < 0) {
            System.out.println("Fuel's tank is empty");
            return;
        }
        if (isX) {
            positionX -= step;
        } else {
            positionY -= step;
        }
        fuel -= step;
    }

    public void turnRight() {
        isX = false;
    }

    public void turnLeft() {
        isX = true;
    }

    public void printPosition() {
        System.out.println("The Tank is at " + positionX + ", " + positionY + " now");
    }
}
