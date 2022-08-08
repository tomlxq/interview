package com.tom.leetcode;


public class EratosthenesDemo {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes2(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] prime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!prime[i]) {
                count++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        prime[j] = true;
                    }
                }
            }
        }
        return count;
    }
}
