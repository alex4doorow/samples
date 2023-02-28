package com.sir.richard.boss.collections;

import java.util.ArrayList;

public class ArrayListMain {
    public static void main(String[] args) {
        // https://habr.com/ru/post/128269/
        ArrayList<String> list = new ArrayList<>(2000);
        for (int i = 0; i <= 2000; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println(list.size());
        list.add("one");
        System.out.println(list.get(1011));
        list.add(1011, "two");
        System.out.println(list.get(1011));

        list.remove(1011);
        System.out.println(list.get(1010));
        System.out.println(list.get(1011));
        System.out.println(list.get(1012));
        System.out.println(list.size());



    }
}
