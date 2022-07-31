package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConcatWordTest {
    ConcatWord cw = null;

    @Before
    public void setUp() throws Exception {
        cw = new ConcatWord();
    }

    @Test
    public void func() {
        assertEquals("worddwordda", cw.func(0, "word dd da dc dword d"));
        assertEquals("dwordda", cw.func(4, "word dd da dc dword d"));
    }
}