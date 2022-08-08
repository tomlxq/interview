package com.tom.leetcode;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class BfsDemoTest {
    BfsDemo bd = null;

    @Before
    public void setUp() throws Exception {
        bd = new BfsDemo();
    }

    @Test
    public void ladderLength() {
        assertEquals(5, bd.ladderLength("hit",
                "cog",
                Lists.newArrayList("hot", "dot", "dog", "lot", "log", "cog")));
        assertEquals(0, bd.ladderLength("hit",
                "cog",
                Lists.newArrayList("hot", "dot", "dog", "lot", "log")));
        assertEquals(5, bd.ladderLength2("hit",
                "cog",
                Lists.newArrayList("hot", "dot", "dog", "lot", "log", "cog")));
        assertEquals(0, bd.ladderLength2("hit",
                "cog",
                Lists.newArrayList("hot", "dot", "dog", "lot", "log")));

    }


    @Test
    public void hasPath() {


        int[][] maze1 = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] destination = {4, 4};
        assertTrue(bd.hasPath(maze1, start, destination));
        int[][] maze2 = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        assertFalse(bd.hasPath(maze2, start, new int[]{3, 2}));
        assertTrue(bd.hasPath2(maze1, start, destination));
        assertFalse(bd.hasPath2(maze2, start, new int[]{3, 2}));
    }

    @Test
    public void minimumMoves() {
        /**
         * 输入：grid = {{0,0,0,0,0,1},{1,1,0,0,1,0},{0,0,0,0,1,1},{0,0,1,0,1,0},{0,1,1,0,0,0},{0,1,1,0,0,0}}
         * 输出：11
         * 解释：
         * 一种可能的解决方案是 [右, 右, 顺时针旋转, 右, 下, 下, 下, 下, 逆时针旋转, 右, 下]。
         *
         */
        assertEquals(11, bd.minimumMoves(new int[][]{{0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 0, 0}}));

    }

    @Test
    public void minPathSum() {
        /**
         * grid = {{1,3,1},{1,5,1},{4,2,1}}
         * 输出：7
         */
        assertEquals(7, bd.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        assertEquals(12, bd.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));

    }


    @Test
    public void findCircleNum() {
        //isConnected = 1,0,0],[0,1,0],[0,0,1]
        //输出：2
        assertEquals(2, bd.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        assertEquals(3, bd.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        assertEquals(2, bd.findCircleNum2(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        assertEquals(3, bd.findCircleNum2(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        assertEquals(2, bd.findCircleNum3(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        assertEquals(3, bd.findCircleNum3(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }
}