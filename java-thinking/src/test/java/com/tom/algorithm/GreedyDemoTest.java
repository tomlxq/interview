package com.tom.algorithm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreedyDemoTest {
    GreedyDemo gd = null;

    @Before
    public void setUp() throws Exception {
        gd = new GreedyDemo();
    }

    @Test
    public void findLengthOfLCIS() {

        assertEquals(3, gd.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        assertEquals(1, gd.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
    }

    @Test
    public void lemonadeChange() {
        //输入：bills = [5,5,5,10,20]
        //输出：true
        assertTrue(gd.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        assertFalse(gd.lemonadeChange(new int[]{5, 5, 10, 10, 20}));

    }

    @Test
    public void largestPerimeter() {
        assertEquals(5, gd.largestPerimeter(new int[]{2, 1, 2}));
        assertEquals(0, gd.largestPerimeter(new int[]{1, 2, 1}));
    }
}