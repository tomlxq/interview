package com.tom.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class BiteDomeTest {
    BiteDome bd = null;

    @Before
    public void setUp() throws Exception {
        bd = new BiteDome();
    }

    @Test
    public void bit() {
        bd.bit();
    }

    @Test
    public void printOddTimeNum() {
        assertEquals(3, bd.printOddTimeNum(new int[]{1, 1, 3, 3, 3, 7, 7, 8, 8}));
    }

    @Test
    public void printOddTimeNum2() {
        int[] ret = bd.printOddTimeNum2(new int[]{1, 1, 3, 3, 3, 7, 7, 8, 8, 1000});
        log.info("{}", ret);
        assertTrue(Arrays.equals(ret, new int[]{1000, 3}));
    }
}