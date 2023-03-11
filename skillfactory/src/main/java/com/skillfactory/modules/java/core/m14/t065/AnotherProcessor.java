package com.skillfactory.modules.java.core.m14.t065;

class AnotherProcessor implements Runnable {

    private int elem;

    public AnotherProcessor(int elem) {
        this.elem = elem;
    }

    @Override
    public void run() {
        Main.set.remove("Key" + elem);
    }
}

