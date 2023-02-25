package com.skillfactory.modules.java.core.hw02.hw0202;

public class Orc implements Playable {
    @Override
    public String move() {
        return "run";
    }

    @Override
    public String attack() {
        return "ax blow";
    }

    @Override
    public String defence() {
        return "block";
    }
}
