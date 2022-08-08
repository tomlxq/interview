package com.tom.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DpDemoTest {
    DpDemo dp = null;

    @Before
    public void setUp() throws Exception {
        dp = new DpDemo();
    }

    @Test
    public void climbStairs() {
        assertEquals(2, dp.climbStairs(2));
        assertEquals(3, dp.climbStairs(3));
        assertEquals(2, dp.climbStairs2(2));
        assertEquals(3, dp.climbStairs2(3));

    }

    @Test
    public void numSquares() {
        assertEquals(3, dp.numSquares(12));
        assertEquals(2, dp.numSquares(13));
        assertEquals(3, dp.numSquares2(12));
        assertEquals(2, dp.numSquares2(13));
    }

    @Test
    public void maxProduct() {
        assertEquals(6, dp.maxProduct(new int[]{2, 3, -2, 4}));
        assertEquals(0, dp.maxProduct(new int[]{-2, 0, -1}));
    }

    @Test
    public void maxProfit() {
        assertEquals(5, dp.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, dp.maxProfit(new int[]{7, 6, 4, 3, 1}));
        assertEquals(5, dp.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, dp.maxProfit2(new int[]{7, 6, 4, 3, 1}));

    }

    @Test
    public void maxProfit122() {
        assertEquals(7, dp.maxProfit122(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(4, dp.maxProfit122(new int[]{1, 2, 3, 4, 5}));
        assertEquals(0, dp.maxProfit122(new int[]{7, 6, 4, 3, 1}));
        assertEquals(7, dp.maxProfit1222(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(4, dp.maxProfit1222(new int[]{1, 2, 3, 4, 5}));
        assertEquals(0, dp.maxProfit1222(new int[]{7, 6, 4, 3, 1}));
    }

    @Test
    public void maxProfit123() {
        assertEquals(6, dp.maxProfit123(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        assertEquals(4, dp.maxProfit123(new int[]{1, 2, 3, 4, 5}));
        assertEquals(0, dp.maxProfit123(new int[]{7, 6, 4, 3, 1}));
        assertEquals(0, dp.maxProfit123(new int[]{1}));
    }
}