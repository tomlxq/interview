package com.tom.huawei;


import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConcatArrayDemoTest {
    ConcatArrayDemo cad = null;

    @Before
    public void setUp() throws Exception {
        cad = new ConcatArrayDemo();
    }

    @Test
    public void func() {
        assertEquals("2,5,6,1,7,4,7,9,5,3,4,7", cad.func(Lists.newArrayList("2,5,6,7,9,5,7", "1,7,4,3,4"), 3));
        assertEquals("1,2,3,4,1,2,3,1,2,3,4,5,6", cad.func(Lists.newArrayList("1,2,3,4,5,6", "1,2,3", "1,2,3,4"), 4));
    }
}