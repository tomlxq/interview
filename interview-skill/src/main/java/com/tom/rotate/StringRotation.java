package com.tom.rotate;

import java.util.Arrays;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/85062aa6016640d188a6a0daf9f5da0e?orderByHotValue=0&questionTypes=000100&mutiTagIds=639&page=1&onlyReference=false
 * 来源：牛客网
 *
 * 对于一个字符串，和字符串中的某一位置，请设计一个算法，将包括i位置在内的左侧部分移动到右边，将右侧部分移动到左边。
 *
 * 给定字符串A和它的长度n以及特定位置p，请返回旋转后的结果。
 *
 * 测试样例：
 * "ABCDEFGH",8,4
 * 返回："FGHABCDE"
 *
 * @author TomLuo
 * @date 2020/3/7
 */

public class StringRotation {
    public String rotateString(String A, int n, int p) {
        // write code here
        return A.substring(p + 1).concat(A.substring(0, p+1));

    }
    public String rotateString1(String A, int n, int p) {
        // write code here
       // final char[] chars1 = new char[p+1];
        //ABCDEFGHABCDEFGH
        //FGHABCDE
        //"PQWIVLQQ",8,5
        //PQWIVLQQPQWIVLQQ
        //
       return A.concat(A).substring(p+1,p+1+n);
    }
}

