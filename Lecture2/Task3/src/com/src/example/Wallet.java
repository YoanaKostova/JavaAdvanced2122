package com.src.example;

public class Wallet {
    private double amount;

    public Wallet(double amount) {
        this.amount = amount;
    }

    public synchronized double getAmount() {
        return amount;
    }

    public synchronized void withdraw(double money){
        if (amount < money){
            System.out.println("Not enough money!");
        }else{
            this.amount -= money;
            System.out.println("Account balance = " + this.amount);
        }
    }
}
