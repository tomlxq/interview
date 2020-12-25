package com.tom.one.java.base.alibaba.guide;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public class ArrayExample {
    public static void main(String[] args) {
        String str = "a,b,c,,";
        String[] ary = str.split(",");
// 预期大于 3，结果是 3
        System.out.println(ary.length);
    }
}
