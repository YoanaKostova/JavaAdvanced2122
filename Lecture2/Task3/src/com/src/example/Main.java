package com.src.example;

public class Main {

    public static void main(String[] args) {
        Wallet wallet = new Wallet(200);
        SpendMoney spendMoney = new SpendMoney(wallet,80);

        Thread t1 = new Thread(spendMoney);
        t1.start();
        Thread t2 = new Thread(spendMoney);
        t2.start();
        Thread t3 = new Thread(spendMoney);
        t3.start();

    }
}
