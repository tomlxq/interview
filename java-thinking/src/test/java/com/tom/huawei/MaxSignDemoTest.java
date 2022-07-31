package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxSignDemoTest {
    MaxSignDemo msd = null;

    @Before
    public void setUp() throws Exception {
        msd = new MaxSignDemo();
    }

    @Test
    public void func() {
        assertEquals("01010", msd.func("00101010101100001010010"));
        assertEquals("-1", msd.func("0110"));
    }
}