package com.skillfactory.modules.java.core.hw02.hw0207;

public class Car extends Transport {
    int maxPassengers;

    public Car(int fuel, int speed, int maxPassengers) {
        super(fuel, speed);
        this.maxPassengers = maxPassengers;
    }

    @Override
    public boolean canMove(int n) {
        if (fuel >= n) {
            fuel -= n;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getFuelLevel() {
        return fuel;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }
}
