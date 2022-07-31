package com.tom.algorithm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SlideWindowDemoTest {
    SlideWindowDemo swd = null;

    @Before
    public void setUp() throws Exception {
        swd = new SlideWindowDemo();
    }

    @Test
    public void findMaxAverage() {
        //输入：nums = [1,12,-5,-6,50,3], k = 4
        //输出：12.75
        assertEquals(12.75, swd.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4), 0.00);
    }
}