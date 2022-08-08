package com.tom.leetcode;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class CityDemoTest {
    CityDemo cd = null;

    @Before
    public void setUp() throws Exception {
        cd = new CityDemo();
    }

    @Test
    public void findTheCity() {


        assertEquals(0, cd.findTheCity(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2));
        assertEquals(3, cd.findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
        assertEquals(0, cd.findTheCity(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2));
        assertEquals(3, cd.findTheCity2(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
        assertEquals(0, cd.findTheCity2(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2));
        assertEquals(3, cd.findTheCity3(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
        assertEquals(0, cd.findTheCity3(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2));
        assertEquals(3, cd.findTheCity4(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
        assertEquals(0, cd.findTheCity4(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2));
        assertEquals(3, cd.findTheCity5(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
        assertEquals(0, cd.findTheCity5(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2));
        assertEquals(3, cd.findTheCity6(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
        assertEquals(0, cd.findTheCity6(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2));


    }

    @Test
    public void canVisitAllRooms() {

        ArrayList<List<Integer>> rooms1 = Lists.newArrayList(
                Lists.newArrayList(1),
                Lists.newArrayList(2), Lists.newArrayList(3), Lists.newArrayList());

        ArrayList<List<Integer>> rooms2 = Lists.newArrayList(
                Lists.newArrayList(1, 3),
                Lists.newArrayList(3, 0, 1), Lists.newArrayList(2), Lists.newArrayList(0));
        assertTrue(cd.canVisitAllRooms(rooms1));
        assertFalse(cd.canVisitAllRooms(rooms2));
        assertTrue(cd.canVisitAllRooms2(rooms1));
        assertFalse(cd.canVisitAllRooms2(rooms2));


        /**
         * 输入：rooms = [[1],[2],[3],[]]
         * 输出：true
         * 解释：
         * 我们从 0 号房间开始，拿到钥匙 1。
         * 之后我们去 1 号房间，拿到钥匙 2。
         * 然后我们去 2 号房间，拿到钥匙 3。
         * 最后我们去了 3 号房间。
         * 由于我们能够进入每个房间，我们返回 true。
         * 示例 2：
         *
         * 输入：rooms = [[1,3],[3,0,1],[2],[0]]
         * 输出：false
         * 解释：我们不能进入 2 号房间。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode.cn/problems/keys-and-rooms
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
    }
}