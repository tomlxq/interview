package com.tom.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RecursiveDemoTest {
    RecursiveDemo rd = null;

    @Before
    public void setUp() throws Exception {
        rd = new RecursiveDemo();
    }

    @Test
    public void predictTheWinner() {
        //输入：nums = [1,5,2]
        //输出：false
        assertFalse(rd.PredictTheWinner(new int[]{1, 5, 2}));

        assertTrue(rd.PredictTheWinner(new int[]{1, 5, 233, 7}));
        assertFalse(rd.PredictTheWinner2(new int[]{1, 5, 2}));

        assertTrue(rd.PredictTheWinner2(new int[]{1, 5, 233, 7}));
        assertFalse(rd.PredictTheWinner3(new int[]{1, 5, 2}));

        assertTrue(rd.PredictTheWinner3(new int[]{1, 5, 233, 7}));
        assertTrue(rd.PredictTheWinner3(new int[]{1, 3, 1}));
//[1,3,1]
        assertFalse(rd.PredictTheWinner4(new int[]{1, 5, 2}));
        assertTrue(rd.PredictTheWinner4(new int[]{1, 5, 233, 7}));

    }
}