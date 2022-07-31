package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MiniStopBusTest {
    MiniStopBus msb = null;

    @Before
    public void setUp() throws Exception {
        msb = new MiniStopBus();
    }

    @Test
    public void func() {
        assertEquals(2, msb.func("1,0,1"));
        assertEquals(3, msb.func("1,1,0,0,1,1,1,0,1"));
        assertEquals(2, msb.func2("1,0,1"));
        assertEquals(3, msb.func2("1,1,0,0,1,1,1,0,1"));


    }
}