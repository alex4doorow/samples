package com.skillfactory.modules.java.core.m14.t001.v1;

public class Client implements Runnable {
    private Bank bank;

    public Client(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (true) {
            bank.take(1000);
            bank.repay(1000);
        }
    }
}
