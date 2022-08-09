package com.tom.huawei;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class CreateDataCategory {
    public int func(String line) {
        int[] data = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int c = data[0];
        int b = data[1];
        int[] nums = IntStream.range(2, data.length).map(i -> data[i]).toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            String s = StringUtils.leftPad(Integer.toHexString(i), 8, '0');
            int temp = 0;
            for (int j = 0; j < s.length(); j += 2) {
                temp += Integer.parseInt(s.substring(j, j + 2), 16);
            }
            int t = temp % b;

            if (t < c) {
                map.put(t, map.getOrDefault(t, 0) + 1);
            }
        }
        List<Integer> values = map.values().stream().sorted().collect(Collectors.toList());
        return values.get(values.size() - 1);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            CreateDataCategory cdc = new CreateDataCategory();
            System.out.println(cdc.func(sc.nextLine()));
        }
    }
}
