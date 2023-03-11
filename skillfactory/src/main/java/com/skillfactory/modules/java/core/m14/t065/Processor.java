package com.skillfactory.modules.java.core.m14.t065;

class Processor implements Runnable {

    private int elem;

    public Processor(int elem) {
        this.elem = elem;
    }

    @Override
    public void run() {
        Main.set.put("Key" + elem, 12);
    }
}
