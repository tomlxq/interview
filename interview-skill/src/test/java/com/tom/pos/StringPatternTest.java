package com.tom.pos;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/7
 */
public class StringPatternTest {


    @Test
    public void findAppearance() {
        final StringPattern stringPattern = new StringPattern();
       // "acbc",4,"bc",2
       //         * 返回：2
        Assert.assertEquals(2,stringPattern.findAppearance("acbc",4,"bc",2));
    }
}