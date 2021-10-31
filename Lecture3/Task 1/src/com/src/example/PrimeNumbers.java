package com.src.example;

public class PrimeNumbers {
    private int n;
    private int currentNum;

    public PrimeNumbers(int n) {
        this.n = n;
        currentNum = 2;
    }

    public synchronized void getAllPrimeNumbers(){
        if (currentNum == 2){
            System.out.println(currentNum++);
        }
        if(currentNum <= n){
            if(isPrime(currentNum))
                System.out.println(currentNum);
            currentNum += 2;
        }
    }

    private boolean isPrime(int k){
        for (int i = 2; i <= Math.sqrt(k); i++) {
            if(k % i == 0)
                return false;
        }
        return true;
    }
}
