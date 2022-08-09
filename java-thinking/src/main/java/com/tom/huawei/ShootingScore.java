package com.tom.huawei;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class ShootingScore {
    public String func(int times, String ids, String scores) {
        String[] aryIds = ids.split(",");
        int[] aryScores = Arrays.stream(scores.split(",")).mapToInt(Integer::parseInt).toArray();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < times; i++) {
            List<Integer> list = map.getOrDefault(aryIds[i], new ArrayList<Integer>());
            list.add(aryScores[i]);
            map.put(aryIds[i], list);
        }
        ArrayList<Map.Entry<String, List<Integer>>> entries = new ArrayList<>(map.entrySet());
        Map<String, Integer> sorted = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : entries) {
            List<Integer> value = entry.getValue();
            if (value.size() > 2) {
                Collections.sort(value);
                Collections.reverse(value);
                sorted.put(entry.getKey(), IntStream.range(0, 3).map(i -> i < value.size() && i < 3 ? value.get(i) : 0).sum());
            }
        }
        List<Map.Entry<String, Integer>> entries2 = new ArrayList<>(sorted
                .entrySet());
        Collections.sort(entries2, (e1, e2) -> e1.getValue().compareTo(e2.getValue()) == 0 ? e1.getKey().compareTo(e2.getKey()) : e1.getValue().compareTo(e2.getValue()));
        Collections.reverse(entries2);
        return entries2.stream().map(i -> i.getKey()).collect(Collectors.joining(","));
    }
}
