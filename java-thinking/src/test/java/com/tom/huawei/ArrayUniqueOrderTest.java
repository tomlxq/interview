package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayUniqueOrderTest {
    ArrayUniqueOrder auo = null;

    @Before
    public void setUp() throws Exception {
        auo = new ArrayUniqueOrder();
    }

    @Test
    public void func() {
        assertEquals("3,4,1,2,5", auo.func("1,3,3,3,2,4,4,4,5"));
    }
}