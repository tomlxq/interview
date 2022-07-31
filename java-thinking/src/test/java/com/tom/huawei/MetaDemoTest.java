package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MetaDemoTest {
    MetaDemo md = null;

    @Before
    public void setUp() throws Exception {
        md = new MetaDemo();
    }

    @Test
    public void fun() {
        assertEquals(md.fun(0, "asdbuiodevauufgh"), 3);
        assertEquals(md.fun(2, "aeueo"), 0);
        assertEquals(md.fun(1, "aabeebuu"), 5);
    }
}