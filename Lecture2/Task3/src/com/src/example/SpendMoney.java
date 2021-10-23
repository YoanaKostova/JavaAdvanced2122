package com.src.example;

public class SpendMoney implements Runnable{
    private Wallet wallet;
    private double withdrawMoney;

    public SpendMoney(Wallet wallet) {
        this.wallet = wallet;
    }

    public SpendMoney(Wallet wallet, double withdrawMoney) {
        this.wallet = wallet;
        this.withdrawMoney = withdrawMoney;
    }

    @Override
    public void run() {
        wallet.withdraw(this.withdrawMoney);
    }
}
