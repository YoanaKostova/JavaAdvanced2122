package com.src.example;

public class Account {
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void debit(double money){
        if(this.balance < money){
            System.out.println("Not enough money!");
        }else{
            this.balance -= money;
        }
    }

    public void credit(double money){
        this.balance += money;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
