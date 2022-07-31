package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxBracketNumTest {
    MaxBracketNum mbn = null;

    @Before
    public void setUp() throws Exception {
        mbn = new MaxBracketNum();
    }

    @Test
    public void func() {
        //输入:[]
        //输出:1
        assertEquals(1, mbn.func("[]"));
        assertEquals(3, mbn.func("{ooo[cccc(ccc)ccc]}"));
        assertEquals(0, mbn.func("{ooo[cccc(ccc]ccc]}"));
    }
}