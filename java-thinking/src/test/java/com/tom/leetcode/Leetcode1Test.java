package com.tom.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class Leetcode1Test {
    Leetcode1 lc1;

    @Before
    public void setUp() throws Exception {
        lc1 = new Leetcode1();
    }

    @Test
    public void twoSum() {//
        //输入：nums = [2,7,11,15], target = 9
        //输出：[0,1]
        Assert.assertTrue(Arrays.equals(lc1.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1}));
        Assert.assertTrue(Arrays.equals(lc1.twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2}));
        Assert.assertTrue(Arrays.equals(lc1.twoSum(new int[]{3, 3}, 6), new int[]{0, 1}));
        Assert.assertTrue(Arrays.equals(lc1.twoSum2(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1}));
        Assert.assertTrue(Arrays.equals(lc1.twoSum2(new int[]{3, 2, 4}, 6), new int[]{1, 2}));
        Assert.assertTrue(Arrays.equals(lc1.twoSum2(new int[]{3, 3}, 6), new int[]{0, 1}));
        Assert.assertTrue(Arrays.equals(lc1.twoSum3(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1}));
        Assert.assertTrue(Arrays.equals(lc1.twoSum3(new int[]{3, 2, 4}, 6), new int[]{1, 2}));
        Assert.assertTrue(Arrays.equals(lc1.twoSum3(new int[]{3, 3}, 6), new int[]{0, 1}));




    }
}