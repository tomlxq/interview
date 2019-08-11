package com.tom.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/10
 */
public class Java10Demo {
    public static void main(String[] args) {
        // 兼容多语言 (JS)
        // Jdk 1.6 Rihno JS on JVM
        var b = new ArrayList<>();
        var a = new String[]{};
        printIn(Arrays.asList(1,2,3,5,6));
    }

    private static void printIn(Iterable<?> iterator){
        for(Object o:iterator){
            System.out.println(o);
        }
    }
}
