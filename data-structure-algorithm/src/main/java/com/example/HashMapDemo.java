package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * hash冲突
 */
public class HashMapDemo {
    int N = 50000;

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        List<String> list = Arrays.asList("Aa", "BB", "C#");
        for (String s : list) {
            System.out.println(s.hashCode());
            map.put(s, s);
        }
    }

    List addList(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            Object o = new Object();
            list.add(0, o);
        }
        return list;
    }
}
