package com.tom.replace;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/b0850698cb41449188344cdb647f3e99?orderByHotValue=0&questionTypes=000100&mutiTagIds=639&page=1&onlyReference=false
 * 来源：牛客网
 * <p>
 * 请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 * <p>
 * 给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
 * <p>
 * 测试样例：
 * "Mr John Smith”,13
 * 返回："Mr%20John%20Smith"
 * ”Hello  World”,12
 * 返回：”Hello%20%20World”
 *
 * @author TomLuo
 * @date 2020/3/4
 */

import java.util.stream.IntStream;

public class Replacement {
    public String replaceSpace(String iniString, int length) {
        //假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成
        if (iniString == null || iniString.length() < 0 || iniString.length() > 1000) {
            return null;
        }
        return iniString.replaceAll(" ", "%20");
    }

    public String replaceSpace2(String iniString, int length) {
        //假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成
        StringBuffer s = new StringBuffer();
        IntStream.rangeClosed(0, iniString.length() - 1).forEach(idx -> {
            final char c = iniString.charAt(idx);
            s.append(c == ' ' ? "%20" : c);
        });
        return s.toString();
    }
}
