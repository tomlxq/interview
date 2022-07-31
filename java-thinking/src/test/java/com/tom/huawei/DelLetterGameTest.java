package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DelLetterGameTest {
    DelLetterGame dlg = null;

    @Before
    public void setUp() throws Exception {
        dlg = new DelLetterGame();
    }


    @Test
    public void fun() {
        assertEquals(dlg.fun("aaaaaaa"), 1);
        assertEquals(dlg.fun("abcaacba"), 0);
    }
}