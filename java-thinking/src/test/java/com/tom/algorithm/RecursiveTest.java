package com.tom.algorithm;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecursiveTest {
    Recursive re = null;

    @Before
    public void setUp() throws Exception {
        re = new Recursive();
    }

    @Test
    public void minimumTotal() {
        /**
         * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
         * 输出：11
         */
        // Lists.newArrayList(2)
        List<List<Integer>> arrayLists = Lists.newArrayList(Lists.newArrayList(2), Lists.newArrayList(3, 4), Lists.newArrayList(6, 5, 7)
                , Lists.newArrayList(4, 1, 8, 3));
        assertEquals(11, re.minimumTotal(arrayLists));
        //输入：triangle = [[-10]]
        //输出：-10
        List<List<Integer>> ary2 = Lists.newArrayList();
        ary2.add(Lists.newArrayList(-10));
        assertEquals(-10, re.minimumTotal(ary2));

        assertEquals(-10, re.minimumTotal2(ary2));
        assertEquals(11, re.minimumTotal2(arrayLists));
    }

    @Test
    public void uniquePaths() {
        assertEquals(28, re.uniquePaths(3, 7));
        assertEquals(3, re.uniquePaths(3, 2));
        assertEquals(28, re.uniquePaths2(3, 7));
        assertEquals(3, re.uniquePaths2(3, 2));


    }

    @Test
    public void uniquePathsWithObstacles() {
        assertEquals(1, re.uniquePathsWithObstacles(new int[][]{{0}}));
        assertEquals(0, re.uniquePathsWithObstacles(new int[][]{{1, 0}}));
        assertEquals(2, re.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        assertEquals(1, re.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
        assertEquals(1, re.uniquePathsWithObstacles2(new int[][]{{0}}));
        assertEquals(0, re.uniquePathsWithObstacles2(new int[][]{{1, 0}}));
        assertEquals(2, re.uniquePathsWithObstacles2(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        assertEquals(1, re.uniquePathsWithObstacles2(new int[][]{{0, 1}, {0, 0}}));

    }

}