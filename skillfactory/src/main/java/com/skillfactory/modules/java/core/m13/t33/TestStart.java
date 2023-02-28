package com.skillfactory.modules.java.core.m13.t33;

class TestStart extends Thread {
    int i;

    public TestStart(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.print(i);
    }
}
