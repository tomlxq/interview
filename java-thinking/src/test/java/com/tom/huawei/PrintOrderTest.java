package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrintOrderTest {
    PrintOrder po = null;

    @Before
    public void setUp() throws Exception {
        po = new PrintOrder();
    }

    @Test
    public void func() {
        assertEquals("0,2,1", po.func("9,3,5"));
        assertEquals("2,0,1", po.func("1,2,2"));
        assertEquals("0,2,3,4,1", po.func("9,3,3,3,5"));
    }
}