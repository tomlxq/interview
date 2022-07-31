package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MiniAbsArrayTest {
    MiniAbsArray maa = null;

    @Before
    public void setUp() throws Exception {
        maa = new MiniAbsArray();
    }

    @Test
    public void func() {
        //-1 -3 7 5 11 15
        //
        //输出
        //
        //-3 5 2
        assertEquals("-3 5 2", maa.func("-1 -3 7 5 11 15"));
    }
}