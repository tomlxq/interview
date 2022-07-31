package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringDemoTest {
    StringDemo sd = null;

    @Before
    public void setUp() throws Exception {
        sd = new StringDemo();
    }

    @Test
    public void findString() {
        assertEquals(3, sd.findString("abc", "abcxaybec"));
        assertEquals(3, sd.findString2("abc", "abcxaybec"));
    }
}