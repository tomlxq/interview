package com.tom.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

@Slf4j
public class OrderDemoTest {
    OrderDemo cd = null;

    @Before
    public void setUp() throws Exception {
        cd = new OrderDemo();
    }

    @Test
    public void insertOrder() {
        int a = 4;
        int b = 3;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        log.info("a={},b={}", a, b);
        int[] data = new int[]{3, 1, 5, 6, 100, 88, 3, 2, 1};
        int[] checkData = data.clone();
        Arrays.sort(checkData);
        cd.insertSort(data);
        assertTrue(Arrays.equals(data, checkData));
    }

    @Test
    public void bubbleSort() {
        int[] data = new int[]{1, 3, 5, 6, 100, 88, 3, 2, 1};
        int[] checkData = data.clone();
        Arrays.sort(checkData);
        log.info("{} {}", data, checkData);
        cd.bubbleSort(data);
        log.info("{}", data);
        assertTrue(Arrays.equals(data, checkData));
    }

    @Test
    public void selectSort() {
        int[] data = new int[]{3, 1, 5, 6, 100, 88, 3, 2, 1};
        int[] checkData = data.clone();
        Arrays.sort(checkData);
        log.info("{} {}", data, checkData);
        cd.selectSort(data);
        log.info("{}", data);
        assertTrue(Arrays.equals(data, checkData));
    }

}