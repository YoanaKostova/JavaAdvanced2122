package com.src.example;

public class Fibonacci implements Runnable{
    private int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        long num1 = 0;
        long num2 = 1;
        for (int i = 0; i < n; i++) {
            System.out.println("Fibonacci -> " + num2);
            long temp = num1 + num2;
            num1 = num2;
            num2 = temp;

        }
    }
}
