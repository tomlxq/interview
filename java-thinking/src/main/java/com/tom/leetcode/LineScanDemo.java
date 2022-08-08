package com.tom.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LineScanDemo {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 2] * nums[n - 3] * nums[n - 1]);
    }

    public int maximumProduct2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }
            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }


    public int[] twoSum3(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 1) {
            return new int[]{};
        }
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            int low = i, high = size - 1;
            while (low <= high) {
                int mid = low + (high - low >> 1);
                if (numbers[mid] == target - numbers[i]) {
                    if (mid == i) {
                        return new int[]{i + 1, mid + 2};
                    }
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSum4(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 1) {
            return new int[]{};
        }
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{};
    }
}

