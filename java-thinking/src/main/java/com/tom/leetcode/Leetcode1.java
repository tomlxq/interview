package com.tom.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1 {
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
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public int[] twoSum3(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int high = nums.length - 1, low = i;
            while (low <= high) {
                int mid = low + (high - low >> 1);
                if (nums[mid] == target - nums[i]) {
                    if (mid == i) {
                        return new int[]{i + 1, mid + 2};
                    }
                    return new int[]{i + 1, mid + 1};
                } else if (nums[mid] < target - nums[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{};
    }
}
