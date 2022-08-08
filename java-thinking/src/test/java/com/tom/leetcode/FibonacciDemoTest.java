package com.tom.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciDemoTest {
    FibonacciDemo fd = null;

    @Before
    public void setUp() throws Exception {
        fd = new FibonacciDemo();
    }

    @Test
    public void fibonacci() {
        assertEquals(1, fd.fb(1));
        assertEquals(55, fd.fb(10));

        assertEquals(1, fd.fb2(1));
        assertEquals(55, fd.fb2(10));
        assertEquals(1, fd.fb3(1));
        assertEquals(55, fd.fb3(10));
        assertEquals(1, fd.fb4(1));
        assertEquals(55, fd.fb4(10));

    }

}