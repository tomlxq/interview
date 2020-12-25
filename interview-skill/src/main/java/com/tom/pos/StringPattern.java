package com.tom.pos;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/084b6cb2ca934d7daad55355b4445f8a?orderByHotValue=0&questionTypes=000100&mutiTagIds=639&page=1&onlyReference=false
 * 来源：牛客网
 *
 * 对于两个字符串A，B。请设计一个高效算法，找到B在A中第一次出现的起始位置。若B未在A中出现，则返回-1。
 *
 * 给定两个字符串A和B，及它们的长度lena和lenb，请返回题目所求的答案。
 *
 * 测试样例：
 * "acbc",4,"bc",2
 * 返回：2
 *
 * @author TomLuo
 * @date 2020/3/7
 */
import java.util.*;

public class StringPattern {
    public int findAppearance(String A, int lena, String B, int lenb) {
        // write code here
        //return A.indexOf(B);
        //"acbc",4,"bc"
                //ac
                //cb
        //bc
        for(int i=0;i<=lena-lenb;i++){
            if(A.substring(i,lenb+i).equals(B)){
                return i;
            }
        }
        return -1;
    }
}