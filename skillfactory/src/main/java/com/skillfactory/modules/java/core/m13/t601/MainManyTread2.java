package com.skillfactory.modules.java.core.m13.t601;

import com.skillfactory.modules.java.core.m13.t34.CheckResults1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainManyTread2 {
    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 1; i <= 10000000; i++) {
                numbers.add(i);
            }
            int max = Collections.max(numbers);
            System.out.println("Max found: " + max);

        });
        t1.setName("1");
        t1.start();

        Thread t2 = new Thread(() -> {

            List<Integer> unsorted = new ArrayList<>();
            for (int i = 10000000; i >= 1; i--) {
                unsorted.add(i);
            }
            Collections.sort(unsorted);
            System.out.println("List is sorted now");

        });
        t2.setName("2");
        t2.start();

        Thread t3 = new Thread(() -> {

            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= 10000000; i++) {
                list.add(i);
            }
            while (list.size() != 0) {
                list.remove(list.size() - 1);
            }
            System.out.println("List cleared");

        });
        t3.setName("3");
        t3.start();

        while (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
            Thread.sleep(100);
        }
/*
        if (t1.isAlive()) {
            try {
                // Прерываем яйцо
                t1.interrupt();
                // Ждем, пока яйцо закончит высказываться
                t1.join();
            } catch (InterruptedException e) {
            }
            System.out.println("1 finished!");
        } else if (t2.isAlive()) {
            try {
                // Прерываем яйцо
                t2.interrupt();
                // Ждем, пока яйцо закончит высказываться
                t2.join();
            } catch (InterruptedException e) {
            }
            System.out.println("2 finished!");
        } else {
            try {
                // Прерываем яйцо
                t3.interrupt();
                // Ждем, пока яйцо закончит высказываться
                t3.join();
            } catch (InterruptedException e) {
            }
            System.out.println("3 finished!");
        }

 */
        long end = System.currentTimeMillis();
        System.out.println("Total time: " + (end - start) + " ms");
    }


}



