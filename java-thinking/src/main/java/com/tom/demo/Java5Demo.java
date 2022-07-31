package com.tom.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/10
 */
public class Java5Demo {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 7, 7, 5, 1, 2, 3};
        int nums2 = test(nums);
        System.out.println(nums2);
        for (int i : nums) {
            System.out.println(i);
        }

    }

    public static int test(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // int size=nums.length-1;
        //int[] nums2 = new int[size];
        //int j = 0;
        int skipIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], nums[i]);
                if (skipIdx > 0) {
                    nums[skipIdx] = nums[i];
                    skipIdx = 0;
                }
            } else {
                skipIdx = i;
            }
        }
        return nums.length;
    }
}
