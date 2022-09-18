package com.tom.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Leetcode70Test {
    Leetcode70 lc70;

    @Before
    public void setUp() throws Exception {
        lc70 = new Leetcode70();
    }

    @Test
    public void climbStairs() {
        assertEquals(2, lc70.climbStairs(2));
        assertEquals(3, lc70.climbStairs(3));
        assertEquals(2, lc70.climbStairs2(2));
        assertEquals(3, lc70.climbStairs2(3));
        assertEquals(2, lc70.climbStairs3(2));
        assertEquals(3, lc70.climbStairs3(3));
    }
}