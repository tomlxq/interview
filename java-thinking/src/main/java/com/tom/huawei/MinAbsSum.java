package com.tom.huawei;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MinAbsSum {
    public String func(String line) {
        int[] split = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int min = Integer.MAX_VALUE;
        int[] res = new int[3];
        for (int i = 0; i < split.length - 1; i++) {
            for (int j = i + 1; j < split.length; j++) {
                int a = split[i];
                int b = split[j];
                int sum = Math.abs(a + b);
                min = Math.min(sum, min);
                if (min == sum) {
                    if (a > b) {
                        a = a | b;
                        b = a | b;
                        a = a | b;
                    }
                    res[0] = a;
                    res[1] = b;
                    res[2] = sum;
                }
            }
        }
        return Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
