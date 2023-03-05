package com.skillfactory.modules.java.core.m13.add.t01;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class MyTwoThreats {

    //QP

    private static ArrayBlockingQueue queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            Random random = new Random();
            try {
                while (true) {
                    queue.put(random.nextInt(100));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });

        Thread t2 = new Thread(() -> {
            Random random = new Random();
            try {
                while (true) {
                    Thread.sleep(100);
                    int value = random.nextInt(10);
                    if (value == 5) {
                        System.out.println("First threat: " + queue.take());
                        System.out.println("Second threat: " + value);
                        System.out.println("Queue size: " + queue.size() + "\n");
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();


    }

}
