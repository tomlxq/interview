package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecompressPacketTest {
    DecompressPacket dp = null;

    @Before
    public void setUp() throws Exception {
        dp = new DecompressPacket();
    }

    @Test
    public void func() {
        //3[k]2[mn]
        //输出
        //kkkmnmn
        assertEquals("kkkmnmn", dp.func("3[k]2[mn]"));
        assertEquals("mccmccmcc", dp.func("3[m2[c]]"));


    }
}