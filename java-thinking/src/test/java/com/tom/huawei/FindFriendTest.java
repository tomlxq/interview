package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindFriendTest {
    FindFriend fr = null;

    @Before
    public void setUp() throws Exception {
        fr = new FindFriend();
    }

    @Test
    public void findFriend() {
        assertEquals("0 0", fr.findFriend("2", "100 95"));
        // 8
        //        123 124 125 121 119 122 126 123
        //      输出
        //
        assertEquals("1 2 6 5 5 6 0 0", fr.findFriend("8", "123 124 125 121 119 122 126 123"));
    }
}