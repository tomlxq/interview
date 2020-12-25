package com.tom.one.java.base.alibaba.guide;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
@Slf4j
public class FinallyExampleTest {

    @Test
    public void checkReturn() {
        FinallyExample fx=new FinallyExample();
        final int returnNum = fx.checkReturn();
        Assert.assertEquals(2,returnNum);
        System.out.printf("%d", returnNum);
    }
}