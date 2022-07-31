package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalMinSumDemoTest {
    CalMinSumDemo cms = null;

    @Before
    public void setUp() throws Exception {
        cms = new CalMinSumDemo();
    }

    @Test
    public void fun() {
        assertEquals(cms.fun("3 1 1 2", "3 1 2 3", 2), 4);
        assertEquals(cms.fun("3 1 3 4", "3 1 2 3", 4), 13);


    }
}