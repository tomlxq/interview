package com.tom.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class LineScanDemoTest {
    LineScanDemo lsd;

    @Before
    public void setUp() throws Exception {
        lsd = new LineScanDemo();
    }

    @Test
    public void maximumProduct() {
        assertEquals(6, lsd.maximumProduct(new int[]{1, 2, 3}));
        assertEquals(24, lsd.maximumProduct(new int[]{1, 2, 3, 4}));
        assertEquals(-6, lsd.maximumProduct(new int[]{-1, -2, -3}));
        assertEquals(39200, lsd.maximumProduct(new int[]{-100, -98, -1, 2, 3, 4}));
        assertEquals(6, lsd.maximumProduct2(new int[]{1, 2, 3}));
        assertEquals(24, lsd.maximumProduct2(new int[]{1, 2, 3, 4}));
        assertEquals(-6, lsd.maximumProduct2(new int[]{-1, -2, -3}));
        assertEquals(39200, lsd.maximumProduct2(new int[]{-100, -98, -1, 2, 3, 4}));


    }

    @Test
    public void twoSum() {
        assertTrue(Arrays.equals(lsd.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1}));
        assertTrue(Arrays.equals(lsd.twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2}));
        assertTrue(Arrays.equals(lsd.twoSum(new int[]{3, 3}, 6), new int[]{0, 1}));
        assertTrue(Arrays.equals(lsd.twoSum2(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1}));
        assertTrue(Arrays.equals(lsd.twoSum2(new int[]{3, 2, 4}, 6), new int[]{1, 2}));
        assertTrue(Arrays.equals(lsd.twoSum2(new int[]{3, 3}, 6), new int[]{0, 1}));


        assertTrue(Arrays.equals(lsd.twoSum3(new int[]{2, 7, 11, 15}, 9), new int[]{1, 2}));
        assertTrue(Arrays.equals(lsd.twoSum3(new int[]{2, 3, 4}, 6), new int[]{1, 3}));
        assertTrue(Arrays.equals(lsd.twoSum3(new int[]{-1, 0}, -1), new int[]{1, 2}));
        assertTrue(Arrays.equals(lsd.twoSum4(new int[]{2, 7, 11, 15}, 9), new int[]{1, 2}));
        assertTrue(Arrays.equals(lsd.twoSum4(new int[]{2, 3, 4}, 6), new int[]{1, 3}));
        assertTrue(Arrays.equals(lsd.twoSum4(new int[]{-1, 0}, -1), new int[]{1, 2}));


    }
}