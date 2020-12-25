package com.tom.replace;

import lombok.extern.slf4j.Slf4j;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/f094aed769d84cf3b799033c82fc1bf6?orderByHotValue=0&questionTypes=000100&mutiTagIds=639&page=1&onlyReference=false
 * 来源：牛客网
 * <p>
 * 请你实现一个简单的字符串替换函数。原串中需要替换的占位符为"%s",请按照参数列表的顺序一一替换占位符。若参数列表的字符数大于占位符个数。则将剩下的参数字符添加到字符串的结尾。
 * <p>
 * 给定一个字符串A，同时给定它的长度n及参数字符数组arg，请返回替换后的字符串。保证参数个数大于等于占位符个数。保证原串由大小写英文字母组成，同时长度小于等于500。
 * <p>
 * 测试样例：
 * "A%sC%sE",7,['B','D','F']
 * 返回："ABCDEF"
 *
 * @author TomLuo
 * @date 2020/3/4
 */
@Slf4j
public class StringFormat {
    public String formatString(String A, int n, char[] arg, int m) {
        StringBuffer s1 = new StringBuffer();
        int j = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '%' && A.charAt(i + 1) == 's') {
                i++;
                s1.append(arg[j]);
                j++;
            } else {
                s1.append(A.charAt(i));
            }
        }
        if (arg.length > j) {
            for (; j < arg.length; j++) {
                s1.append(arg[j]);
            }
        }
        // write code here
        return s1.toString();
    }

    public String formatString2(String A, int n, char[] arg, int m) {
        int i = 0;
        while (A.indexOf("%s") != -1) {
            A = A.replaceFirst("%s", String.valueOf(arg[i++]));
        }
        while (arg.length > i) {
            A += String.valueOf(arg[i++]);
        }
        return A;
    }
}