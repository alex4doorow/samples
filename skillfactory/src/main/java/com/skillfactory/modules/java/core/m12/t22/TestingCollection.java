package com.skillfactory.modules.java.core.m12.t22;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class TestingCollection {

    public static void main(String[] args) {
        Queue queue = new ArrayDeque();
        System.out.println(queue.peek());

        Deque queue2 = new ArrayDeque();
        System.out.println(queue2.pop());

        Deque queue3 = new ArrayDeque();
        System.out.println(queue3.remove());
    }
}
