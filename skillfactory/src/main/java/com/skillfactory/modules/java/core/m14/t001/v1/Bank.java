package com.skillfactory.modules.java.core.m14.t001.v1;

import lombok.Data;

@Data
public class Bank {

    private int money = 10000;

    public Bank() {
        Thread t1 = new Thread(new Client(this));
        Thread t2 = new Thread(new Client(this));
        Thread t3 = new Thread(new Client(this));

        t1.start();
        t2.start();
        t3.start();
    }

    public synchronized void take(int money) {
        this.money -= money;
    }

    public synchronized void repay(int money) {
        this.money += money;
    }

    public void showMoney() {
        System.out.println(money);
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        while(true) {
            bank.showMoney();
            Thread.sleep(1000);
        }
    }
}
