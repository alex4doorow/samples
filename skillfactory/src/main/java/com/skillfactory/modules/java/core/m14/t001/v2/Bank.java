package com.skillfactory.modules.java.core.m14.t001.v2;

import lombok.Data;

@Data
public class Bank {

    private int money = 10000;
    // переменная, по которой и будем синхронизироваться
    private Object lock = new Object();

    public int getMoney() {
        return money;
    }

    public void take(int money) {
        synchronized (lock) {
            this.money -= money;
        }
    }

    public void repay(int money) {
        synchronized (lock) {
            this.money += money;
        }
    }

    public Bank() {
        new Client(this).start();
        new Client(this).start();
        new Client(this).start();
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        while (true) {
            System.out.println(bank.money);
            Thread.sleep(1000);
        }
    }
}
