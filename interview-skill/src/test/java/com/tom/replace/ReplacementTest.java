package com.tom.replace;

import com.tom.replace.Replacement;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 *
 * 给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
 *
 * 测试样例：
 * "Mr John Smith”,13
 * 返回："Mr%20John%20Smith"
 * ”Hello  World”,12
 * 返回：”Hello%20%20World”
 *
 * @author TomLuo
 * @date 2020/3/4
 */
public class ReplacementTest {
    @Test
    public void name() {
        Replacement replacement=new Replacement();
        assertEquals("Mr%20John%20Smith",  replacement. replaceSpace("Mr John Smith",13));
        assertEquals("Hello%20%20World",  replacement. replaceSpace("Hello  World",13));
        assertEquals("Mr%20John%20Smith",  replacement. replaceSpace2("Mr John Smith",13));
        assertEquals("Hello%20%20World",  replacement. replaceSpace2("Hello  World",13));
    }
}