package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MartionTest {
    Martion m = null;

    @Before
    public void setUp() throws Exception {
        m = new Martion();
    }

    @Test
    public void process() {
        assertEquals(226, m.func("7#6$5#12"));
        assertEquals(226, m.fun2("7#6$5#12"));

    }
}