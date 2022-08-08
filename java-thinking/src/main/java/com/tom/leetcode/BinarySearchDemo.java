package com.tom.leetcode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinarySearchDemo {
    public int mySqrt0(int x) {
        for (int i = 1; i < x; i++) {
            if (i * i == x) {
                return i;
            } else if (i * i < x && (i + 1) * (i + 1) > x) {
                return i;
            }
        }
        return -1;
    }

    public int mySqrt(int x) {
        int idx = 0, l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l >> 1);
            if (mid * mid <= x) {
                idx = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return idx;
    }

    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        return (int) sqrt(x, x);
    }

    private double sqrt(double i, int x) {
        double res = (x / i + i) / 2;
        if (res == i) {
            return res;
        }
        return sqrt(res, x);
    }

    public int arrangeCoins(int n) {
        for (int i = 1; i <= n; i++) {
            n -= i;
            if (n <= i) {
                return i;
            }
        }
        return n;
    }

    public int arrangeCoins2(int n) {
        if (n == 0) {
            return 0;
        }

        int low = 0, high = n;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            long cost = ((mid + 1) * mid) / 2;
            if (cost == n) {
                return (int) mid;
            } else if (cost > n) {
                high = (int) mid - 1;
            } else {
                low = (int) mid + 1;
            }
        }
        return high;
    }

    public int arrangeCoins3(int n) {
        if (n == 0) {
            return 0;
        }
        //(x+n/x)/2=x*x    (x*x+x)/2=n
        return (int) sqrt2(n, n);
    }

    public double sqrt2(double x, int n) {
        double res = (x + (2 * n - x) / x) / 2;
        if (res == x) {
            return x;
        }
        return sqrt2(res, n);
    }

    //(i*i+i)/2=n  4i*i+4i+1=8n+1
    public int arrangeCoins4(int n) {
        return (int) (Math.sqrt((long) 8 * n + 1) - 1) / 2;
    }

    public int arrangeCoins5(int n) {
        int res = 0;
        while (res < n) {
            n -= ++res;
        }
        return res;
    }
}
