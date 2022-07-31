package com.tom.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class DoublePointDemoTest {
    DoublePointDemo dpd = null;

    @Before
    public void setUp() throws Exception {
        dpd = new DoublePointDemo();
    }

    @Test
    public void removeDuplicates() {
        assertEquals(2, dpd.removeDuplicates(new int[]{1, 1, 2}));
        assertEquals(5, dpd.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    @Test
    public void pivotIndex() {
        assertEquals(3, dpd.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        assertEquals(-1, dpd.pivotIndex(new int[]{1, 2, 3}));
        assertEquals(0, dpd.pivotIndex(new int[]{2, 1, -1}));
        assertEquals(3, dpd.pivotIndex2(new int[]{1, 7, 3, 6, 5, 6}));
        assertEquals(-1, dpd.pivotIndex2(new int[]{1, 2, 3}));
        assertEquals(0, dpd.pivotIndex2(new int[]{2, 1, -1}));


    }

    @Test
    public void merge() {
        int[] ary = new int[]{1, 2, 3, 0, 0, 0};
        dpd.merge(ary, 3, new int[]{2, 5, 6}, 3);
        assertTrue(Arrays.equals(ary, new int[]{1, 2, 2, 3, 5, 6}));
        int[] ary2 = new int[]{1, 2, 3, 0, 0, 0};
        dpd.merge2(ary2, 3, new int[]{2, 5, 6}, 3);
        assertTrue(Arrays.equals(ary2, new int[]{1, 2, 2, 3, 5, 6}));
        int[] ary3 = new int[]{1, 2, 3, 0, 0, 0};
        dpd.merge3(ary3, 3, new int[]{2, 5, 6}, 3);
        assertTrue(Arrays.equals(ary3, new int[]{1, 2, 2, 3, 5, 6}));

    }
}