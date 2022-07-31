package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindMinNumTest {
    FindMinNum fmn = null;

    @Before
    public void setUp() throws Exception {
        fmn = new FindMinNum();
    }

    @Test
    public void func() {
        assertEquals("0", fmn.func("10", 1));
        assertEquals("200", fmn.func("10200", 1));
        assertEquals("131", fmn.func("2615371", 4));
    }
}