package com.src.example;

public class Main {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(100);
        Thread threadFibonacci = new Thread(fibonacci);
        threadFibonacci.start();
        Factorial factorial = new Factorial(20);
        Thread threadFactorial = new Thread(factorial);
        threadFactorial.start();
    }
}
