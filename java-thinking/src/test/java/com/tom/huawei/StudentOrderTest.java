package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentOrderTest {
    StudentOrder so = null;

    @Before
    public void setUp() throws Exception {
        so = new StudentOrder();
    }

    @Test
    public void func() {
        assertEquals("2134", so.func(4, "100 100 120 130", "40 30 60 50"));
        assertEquals("132", so.func(3, "90 110 90", "45 60 45"));
    }
}