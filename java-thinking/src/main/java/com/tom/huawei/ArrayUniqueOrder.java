package com.tom.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayUniqueOrder {
    public String func(String line) {
        String[] ary = line.split(",");
        Map<String, Integer> map = new HashMap<>();
        for (String c : ary) {
            int num = map.getOrDefault(c, 0);
            map.put(c, ++num);
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());
        return entries.stream().map(i -> i.getKey()).collect(Collectors.joining(","));
    }
}
