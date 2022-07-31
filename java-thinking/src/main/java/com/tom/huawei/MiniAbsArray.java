package com.tom.huawei;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MiniAbsArray {
    public String func(String line) {
        //-1 -3 7 5 11 15
        int[] split = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int minVal = Integer.MAX_VALUE;
        int[] res = new int[3];
        for (int i = 0; i < split.length - 1; i++) {
            for (int j = i + 1; j < split.length; j++) {
                int tmpSum = Math.abs(split[i] + split[j]);
                minVal = Math.min(minVal, tmpSum);
                if (tmpSum == minVal) {
                    res[0] = split[i];
                    res[1] = split[j];
                    res[2] = minVal;
                }
            }

        }
        return Arrays.stream(res).boxed().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
