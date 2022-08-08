package com.tom.leetcode;

import java.util.Arrays;

public class FibonacciDemo {
    public int fb(int n) {
        if (n <= 1) {
            return n;
        }
        return fb(n - 1) + fb(n - 2);
    }

    public int fb2(int n) {
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        return dfsFB(n, mem);
    }

    private int dfsFB(int n, int[] mem) {
        if (n <= 1) {
            return n;
        }
        if (mem[n] != -1) {
            return mem[n];
        }
        int left = dfsFB(n - 1, mem);
        int right = dfsFB(n - 2, mem);
        mem[n] = (left + right) % 1000000007;
        return mem[n];
    }

    public int fb3(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    public int fb4(int n) {
        if (n <= 1) {
            return n;
        }
        int prev = 0;
        int curr = 1;
        for (int i = 2; i < n + 1; i++) {
            int sum = (prev + curr) % 1000000007;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
