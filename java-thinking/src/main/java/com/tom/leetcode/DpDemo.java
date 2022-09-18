package com.tom.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@Slf4j
public class DpDemo {


    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;//最坏的情况每次加1
            for (int j = 1; i - j * j >= 0; j++) {
                //状态转移方式
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public int numSquares2(int n) {
        if (n <= 3) {
            return n;
        }
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        Set<Integer> visited = new HashSet<>();
        visited.add(n);
        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            int number = a[0];
            int step = a[1];
            int div = (int) Math.pow(number, 0.5);
            for (int i = 1; i <= div; i++) {
                int target = number - i * i;
                if (target == 0) {
                    return step + 1;
                }
                if (!visited.contains(target)) {
                    visited.add(target);
                    queue.add(new int[]{target, step + 1});
                }
            }
        }
        return -1;
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int preMin = nums[0], preMax = nums[0], res = nums[0];
        for (int i = 1; i < len; i++) {
            //如果是负数，会导致最小的变大的，最大小的变最小的
            if (nums[i] < 0) {
                int tmp = preMax;
                preMax = preMin;
                preMin = tmp;
            }
            preMax = Math.max(nums[i] * preMax, nums[i]);
            preMin = Math.min(nums[i] * preMin, nums[i]);
            res = Math.max(preMax, res);
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        //i 第几天
        //k 交易次数 卖入就是k-1 卖出就是k次 只在卖入或买时-1即可
        //j 手里无股票 0 手里有股票 1
        //dp[i][k][0] 第i天，可以交易k次无股票
        //dp[i][k][1] 第i天，可以交易k次有股票
        //初始状态
        //dp[0][1][0]=0  手里无股票 无法卖出，利润为0
        //dp[0][0][1]=-prices[0]   手里有股票，支出price[0]，利润为负price[0]
        //状态转移方程
        //今天手里无股票=max(昨天手里无股票+不做操作，昨天手里有股票+操作卖出）
        //dp[i][k][0]=max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
        //今天手里有股票=max(昨天手里有股票，昨天手里无股票+操作买出）
        //dp[i][k][1]=max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int k = 1;
        int n = prices.length;
        int[][][] dp = new int[n][2][2];
        dp[0][k][0] = 0;
        dp[0][k][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
            dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
        }
        return dp[n - 1][1][0];
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int sell = 0;
        int buy = -prices[0];
        for (int i = 1; i < n; i++) {
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, 0 - prices[i]);
        }
        return sell;
    }

    public int maxProfit122(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public int maxProfit1222(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int sell = 0;
        int buy = -prices[0];
        for (int i = 1; i < n; i++) {
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }

    public int maxProfit123(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int maxNum = 2;
        int[][][] dp = new int[n][maxNum + 1][2];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            for (int k = maxNum; k >= 1; k--) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], (k == 1 ? 0 : dp[i - 1][k - 1][0]) - prices[i]);
            }
        }
        return dp[n - 1][maxNum][0];
    }
}
