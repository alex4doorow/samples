package com.skillfactory.modules.java.core.m12.t33;

import java.util.Collection;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        //Collection<? extends String> collection = new LinkedList<>(); // 2
        Collection<? super String> collection = new LinkedList<>(); // 2
        collection.add("Hello"); // 3
        System.out.println(collection.size());
    }
}
