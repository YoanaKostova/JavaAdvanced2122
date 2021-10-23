package com.src.example;

public class Main {

    public static void main(String[] args) {
        Account a1 = new Account("Ivan", 200);
        Account a2 = new Account("Ivana",950);

        a1.credit(150);
        a1.debit(78);
        System.out.println(a1);

        a2.debit(1000);
    }
}
