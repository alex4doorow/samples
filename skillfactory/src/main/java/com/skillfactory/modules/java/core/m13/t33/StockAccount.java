package com.skillfactory.modules.java.core.m13.t33;

public class StockAccount extends Thread {
    int money = 1000;
    @Override
    public void run() {
        while(true){
            money++;
        }
    }
}
