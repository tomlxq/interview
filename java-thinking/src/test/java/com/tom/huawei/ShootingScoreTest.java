package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShootingScoreTest {
    ShootingScore ss = null;

    @Before
    public void setUp() throws Exception {
        ss = new ShootingScore();
    }

    @Test
    public void func() {
        ////13
        //        //3,3,7,4,4,4,4,7,7,3,5,5,5
        //        //53,80,68,24,39,76,66,16,100,55,53,80,55
        assertEquals("5,3,7,4", ss.func(13, "3,3,7,4,4,4,4,7,7,3,5,5,5", "53,80,68,24,39,76,66,16,100,55,53,80,55"));
    }
}