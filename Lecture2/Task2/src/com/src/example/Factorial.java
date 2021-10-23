package com.src.example;

public class Factorial implements Runnable{
    private int n;

    public Factorial(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
            System.out.println("Factorial -> " + result);
        }
    }
}
