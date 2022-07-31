package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PythagoreanDemoTest {
    PythagoreanDemo pd = null;

    @Before
    public void setUp() throws Exception {
        pd = new PythagoreanDemo();
    }

    @Test
    public void func() {
        assertEquals("3 4 5\n5 12 13\n8 15 17", pd.func(1, 20));
        assertEquals("Na", pd.func(5, 10));
    }
}