package com.tom.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EratosthenesTest {
    EratosthenesDemo as = null;

    @Before
    public void setUp() throws Exception {
        as = new EratosthenesDemo();
    }

    @Test
    public void countPrimes() {
        assertEquals(4, as.countPrimes(10));
        assertEquals(4, as.countPrimes2(10));
    }
}