package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinServerNumTest {
    MinServerNum msn = null;

    @Before
    public void setUp() throws Exception {
        msn = new MinServerNum();
    }

    @Test
    public void func() {
        //assertEquals(3, msn.func(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        //assertEquals(1, msn.func(new int[][]{{1,1}, {1,1}}));
        //assertEquals(2, msn.func(new int[][]{{1,1,0}, {1,1,0}, {0, 0, 1}}));
        assertEquals(3, msn.func2(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        assertEquals(1, msn.func2(new int[][]{{1,1}, {1,1}}));
        assertEquals(2, msn.func2(new int[][]{{1,1,0}, {1,1,0}, {0, 0, 1}}));
    }
}