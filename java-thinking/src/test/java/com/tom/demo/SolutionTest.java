package com.tom.demo;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class SolutionTest {
    Solution s = new Solution();

    @Test
    public void checkRecord1() {

        assertTrue(s.checkRecord1("PPALLP"));
        assertFalse(s.checkRecord1("PPALLL"));
    }


    @Test
    public void checkRecord2() {
        Solution s = new Solution();
        assertTrue(s.checkRecord2("PPALLP"));
        assertFalse(s.checkRecord2("PPALLL"));
    }

    @Test
    public void checkRecord3() {
        assertTrue(s.checkRecord3("PPALLP"));
        assertFalse(s.checkRecord3("PPALLL"));
    }

    @Test
    public void ladderLength() {
        assertEquals(5, s.ladderLength("hit",
                "cog",
                Lists.newArrayList("hot", "dot", "dog", "lot", "log", "cog")));
        assertEquals(0, s.ladderLength("hit",
                "cog",
                Lists.newArrayList("hot", "dot", "dog", "lot", "log")));
    }

    @Test
    public void ladderLength2() {
        assertEquals(5, s.ladderLength2("hit",
                "cog",
                Lists.newArrayList("hot", "dot", "dog", "lot", "log", "cog")));
        assertEquals(0, s.ladderLength2("hit",
                "cog",
                Lists.newArrayList("hot", "dot", "dog", "lot", "log")));
    }


    @Test
    public void computeArea() {
        assertEquals(45, s.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        assertEquals(16, s.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
        assertEquals(45, s.computeArea2(-3, 0, 3, 4, 0, -1, 9, 2));
        assertEquals(16, s.computeArea2(-2, -2, 2, 2, -2, -2, 2, 2));
    }

    @Test
    public void compress() {
        //输入：chars = ["a","a","b","b","c","c","c"]
        //输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode.cn/problems/string-compression
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        assertEquals(6, s.compress(chars));
        chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'};
        assertEquals(7, s.compress(chars));

        assertEquals(6, s.compress(new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'}));
    }

    @Test
    public void lastRemaining() {
        assertEquals(3, s.lastRemaining(5, 3));
        assertEquals(2, s.lastRemaining(10, 17));
        assertEquals(3, s.lastRemaining2(5, 3));
        assertEquals(2, s.lastRemaining2(10, 17));
        assertEquals(3, s.lastRemaining3(5, 3));
        assertEquals(2, s.lastRemaining3(10, 17));
        assertEquals(3, s.lastRemaining4(5, 3));
        assertEquals(2, s.lastRemaining4(10, 17));
        assertEquals(3, s.lastRemaining5(5, 3));
        assertEquals(2, s.lastRemaining5(10, 17));
    }

    @Test
    public void decompressRLElist() {
        /**
         * 输入：nums = [1,2,3,4]
         * 输出：[2,4,4,4]
         * 解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
         * 第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
         * 最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
         * 示例 2：
         *
         * 输入：nums = [1,1,2,3]
         * 输出：[1,3,3]
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode.cn/problems/decompress-run-length-encoded-list
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        assertTrue(s.decompressRLElist(new int[]{1, 2, 3, 4}).equals(new int[]{2, 4, 4, 4}));
        assertTrue(s.decompressRLElist(new int[]{1, 1, 2, 3}).equals(new int[]{1, 3, 3}));
    }

    @Test
    public void compressString() {
        assertEquals("a2b1c5a3", s.compressString("aabcccccaaa"));
        assertEquals("abbccd", s.compressString("abbccd"));
        assertEquals("a2b1c5a3", s.compressString2("aabcccccaaa"));
        assertEquals("abbccd", s.compressString2("abbccd"));

    }

    @Test
    public void sumStopBus() {
        assertEquals(3, s.sumStopBus(new char[]{'1', '1', '0', '0', '1', '1', '1', '0', '1'}));
        assertEquals(2, s.sumStopBus(new char[]{'1', '0', '1'}));
        assertEquals(3, s.sumStopBus1(new char[]{'1', '1', '0', '0', '1', '1', '1', '0', '1'}));
        assertEquals(2, s.sumStopBus1(new char[]{'1', '0', '1'}));

        /** 输入：1，1，0，0，1，1，1，0，1
         * 输出：3
         * 输入：1,0,1
         * 输出：2*/
    }

    @Test
    public void decompressString3() {
        assertEquals("ddddff", s.decompressString3("4dff"));
        assertEquals("!error", s.decompressString3("2dff"));
        assertEquals("!error", s.decompressString3("4d@A"));
        assertEquals("!error", s.decompressString3("22aa"));
        assertEquals("aaabbccccd", s.decompressString3("3abb4cd"));
        //经过压缩变成字符串 3abb4cd
        /**
         * 输入：4dff
         * 输出：ddddff
         * 说明：4d扩展为4个d ，故解压后的字符串为ddddff
         *
         * 输入：2dff
         * 输出：!error
         * 说明：2个d不需要压缩 故输入不合法
         *
         * 输入：4d@A
         * 输出：!error
         * 说明：全部由小写英文字母做成的字符串，压缩后不会出现特殊字符@和大写字母A，故输入不合法
         *
         * 输入：22aa
         * 输出：!error
         */
    }

    @Test
    public void hasPath() {
        int[][] maze = new int[][]{{0, 0, 1, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] start = new int[]{0, 4};
        int[] destination = new int[]{3, 2};
        assertFalse(s.hasPath(maze, start, destination));
        int[][] maze2 = new int[][]{{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}};
        int[] start2 = new int[]{4, 3};
        int[] destination2 = new int[]{0, 1};
        assertFalse(s.hasPath(maze2, start2, destination2));
    }


}