package com.tom.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MaxSignDemo {
    public String func(String line) {
        List<Character> cache = new ArrayList<Character>();
        int max = 0;
        String s = "-1";
        for (char read : line.toCharArray()) {
            if (cache.size() > 0 && cache.get(cache.size() - 1) == '0' && read == '0') {
                String line3 = cache.stream().map(String::valueOf).collect(Collectors.joining());
                if (!line3.contains("11")) {
                    max = Math.max(max, line3.length());
                    if (max == line3.length()) {
                        s = line3;
                    }
                }
                cache.clear();
                cache.add(read);
            } else {
                cache.add(read);
            }
        }
        return s;
    }
}
