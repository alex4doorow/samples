package com.skillfactory.modules.java.core.m14.t001.v4;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Bank {

    private AtomicInteger money = new AtomicInteger(10000);

    public AtomicInteger getMoney() {
        return money;
    }

    public void take(int money) {

        this.money.addAndGet(-money);

    }

    public void repay(int money) {

        this.money.addAndGet(money);

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
