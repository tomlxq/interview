package com.tom.algorithm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchDemoTest {
    BinarySearchDemo bsd;

    @Before
    public void setUp() throws Exception {
        bsd = new BinarySearchDemo();
    }

    @Test
    public void mySqrt() {
        assertEquals(5, bsd.mySqrt0(25));
        assertEquals(4, bsd.mySqrt0(24));
        assertEquals(5, bsd.mySqrt(25));
        assertEquals(4, bsd.mySqrt(24));
        assertEquals(5, bsd.mySqrt2(25));
        assertEquals(4, bsd.mySqrt2(24));


    }

    @Test
    public void arrangeCoins() {
        assertEquals(0, bsd.arrangeCoins(0));
        assertEquals(1, bsd.arrangeCoins(1));
        assertEquals(2, bsd.arrangeCoins(5));
        assertEquals(3, bsd.arrangeCoins(8));
        assertEquals(60070, bsd.arrangeCoins(1804289383));
        assertEquals(2, bsd.arrangeCoins2(5));
        assertEquals(3, bsd.arrangeCoins2(8));
        assertEquals(60070, bsd.arrangeCoins2(1804289383));

        assertEquals(2, bsd.arrangeCoins3(5));
        assertEquals(3, bsd.arrangeCoins3(8));
        //assertEquals(60070,bsd.arrangeCoins3(1804289383));

        assertEquals(2, bsd.arrangeCoins4(5));
        assertEquals(3, bsd.arrangeCoins4(8));
        assertEquals(60070, bsd.arrangeCoins4(1804289383));
        assertEquals(2, bsd.arrangeCoins5(5));
        assertEquals(3, bsd.arrangeCoins5(8));
        assertEquals(60070, bsd.arrangeCoins5(1804289383));

    }
}