package com.src.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        int N = 1000;
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(3);
            PrimeNumbers primeNumbers = new PrimeNumbers(N);
            for (int i = 0; i < N/2; i++) {
                service.submit(()-> primeNumbers.getAllPrimeNumbers());
            }
        } finally {
            if (service != null){
                service.shutdown();
            }
        }
    }
}
