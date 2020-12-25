package com.tom.replace;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/f094aed769d84cf3b799033c82fc1bf6?orderByHotValue=0&questionTypes=000100&mutiTagIds=639&page=1&onlyReference=false
 * 来源：牛客网
 *
 * 请你实现一个简单的字符串替换函数。原串中需要替换的占位符为"%s",请按照参数列表的顺序一一替换占位符。若参数列表的字符数大于占位符个数。则将剩下的参数字符添加到字符串的结尾。
 *
 * 给定一个字符串A，同时给定它的长度n及参数字符数组arg，请返回替换后的字符串。保证参数个数大于等于占位符个数。保证原串由大小写英文字母组成，同时长度小于等于500。
 *
 * 测试样例：
 * "A%sC%sE",7,['B','D','F']
 * 返回："ABCDEF"
 *
 * @author TomLuo
 * @date 2020/3/4
 */
public class StringFormatTest {

    @Test
    public void formatString() {
        StringFormat stringFormat=new StringFormat();
        assertEquals("ABCDEF",stringFormat.formatString("A%sC%sE",7,new char[]{'B','D','F'},5));
        assertEquals("ABCDEF",stringFormat.formatString2("A%sC%sE",7,new char[]{'B','D','F'},5));


    }
}