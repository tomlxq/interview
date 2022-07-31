package com.tom.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class RecursiveDemo {
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        int sum = Arrays.stream(nums).sum();
        int l = 0, r = length - 1;
        int play1 = maxScore(l, r, nums);
        return play1 >= sum - play1;
    }

    private int maxScore(int l, int r, int[] nums) {
        if (l == r) {
            return nums[l];
        }
        int lSum = 0, rSum = 0;
        if (r - l == 1) {
            lSum = nums[l];
            rSum = nums[r];
        }
        if (r - l > 1) {//l+1 r
            int score = maxScore(l + 1, r - 1, nums);
            lSum += nums[l] + Math.min(maxScore(l + 2, r, nums), score);
            //l,r-1
            rSum += nums[r] + Math.min(maxScore(l, r - 2, nums), score);
        }
        return Math.max(lSum, rSum);
    }

    public boolean PredictTheWinner2(int[] nums) {
        int length = nums.length;
        int l = 0, r = length - 1;
        int diff = maxScore2(l, r, nums);
        return diff >= 0;
    }

    private int maxScore2(int l, int r, int[] nums) {
        if (l == r) {
            return nums[l];
        }
        int lSum = 0, rSum = 0;
        lSum += nums[l] - maxScore2(l + 1, r, nums);
        rSum += nums[r] - maxScore2(l, r - 1, nums);
        return Math.max(lSum, rSum);
    }

    public boolean PredictTheWinner3(int[] nums) {


        int length = nums.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            //第i位置和第j位置的差值
            dp[i][i] = nums[i];
        }
        for (int l = length - 2; l >= 0; l--) {
            for (int r = l + 1; r < length; r++) {
                dp[l][r] = Math.max(nums[l] - dp[l + 1][r], nums[r] - dp[l][r - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }

    public boolean PredictTheWinner4(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            //第i位置和第j位置的差值
            dp[i] = nums[i];
        }
        for (int l = length - 2; l >= 0; l--) {
            for (int r = l + 1; r < length; r++) {
                dp[r] = Math.max(nums[l] - dp[r], nums[r] - dp[r - 1]);
            }
        }
        return dp[length - 1] >= 0;
    }
}
