package com.skillfactory.modules.java.core.m12.t32;

public class BoxShippable implements Shippable<Box> {
    @Override
    public void ship(Box stuff) {
        System.out.println("I shipping box: " + stuff);
    }
}
