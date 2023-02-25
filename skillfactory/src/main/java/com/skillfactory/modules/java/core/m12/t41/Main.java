package com.skillfactory.modules.java.core.m12.t41;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //HashSet<Number> hs = new HashSet<Integer>();
        HashSet<? super ClassCastException> set = new HashSet<Exception>();
        //List<Object> values = new HashSet<Object>();
        List<? extends Object> objects = new ArrayList<Object>();
    }
}
