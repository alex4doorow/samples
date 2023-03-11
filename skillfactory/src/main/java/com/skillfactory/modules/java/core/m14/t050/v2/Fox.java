package com.skillfactory.modules.java.core.m14.t050.v2;

public class Fox implements Runnable {

    private static final Food food = new Food();
    private static final Water water = new Water();

    private String name;

    public Fox(String name) {
        this.name = name;
    }

    private void drink() {
        synchronized (water) {
            synchronized (food) {
                System.out.println(name + " got water!");
            }
        }
        move();
    }

    private void eat() {
        synchronized (food) {
            synchronized (water) {
                System.out.println(name + " got food!");
            }
        }
        move();
    }

    private void move() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException exception) {
            // обработать, если требует логика
        }
    }

    public static void main(String[] args) {
        Fox fox1 = new Fox("Richard");
        Fox fox2 = new Fox("Rif");

        new Thread(fox1).start();
        new Thread(fox2).start();
    }

    @Override
    public void run() {
        eat();
        drink();
    }
}