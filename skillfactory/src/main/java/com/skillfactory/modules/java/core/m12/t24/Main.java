package com.skillfactory.modules.java.core.m12.t24;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque deque = new ArrayDeque();
        deque.offer(12);
        deque.add(6);
        deque.add(4);

        deque.poll();
        deque.peek();
        System.out.println(deque.element());
    }
}