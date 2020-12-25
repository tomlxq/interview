package com.tom.order;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/7
 */
public class MaxDivisionTest {

    @Test
    public void findMaxDivision() {
        // * [9,3,1,10],4
         //       * 1 3 9 10
        MaxDivision md=new MaxDivision();
       assertEquals(6,md.findMaxDivision(new int[]{9,3,1,10},4)); ;

    }
}