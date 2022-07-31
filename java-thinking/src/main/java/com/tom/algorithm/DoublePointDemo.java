package com.tom.algorithm;

import java.util.Arrays;

public class DoublePointDemo {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int slow = 0;
        for (int fast = 1; fast < n; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    //2sum+curr=total
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total == sum) {
                return i;
            }
            sum -= nums[i];
        }
        return -1;
    }

    //2sum+curr=total
    public int pivotIndex2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if ((2 * total + curr) == sum) {
                return i;
            }
            total += curr;
        }
        return -1;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] newAry = new int[m];
        System.arraycopy(nums1, 0, newAry, 0, m);
        int p1 = 0, p2 = 0, p = 0;
        while (p1 < m && p2 < n) {
            nums1[p++] = newAry[p1] > nums2[p2] ? nums2[p2++] : newAry[p1++];
        }
        if (p1 < m) {
            System.arraycopy(newAry, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        //while (p2 >= 0) {
        //    nums1[p--] = nums2[p2--];
        //}
    }
}
