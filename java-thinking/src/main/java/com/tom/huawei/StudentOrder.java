package com.tom.huawei;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentOrder {
    public String func(int n, String high, String weight) {
        String[] weightAry = weight.split("\\s+");
        String[] highAry = high.split("\\s+");
        List<int[]> list = IntStream.range(0, n).boxed().map(i -> new int[]{Integer.parseInt(highAry[i]), Integer.parseInt(weightAry[i]), i + 1}).collect(Collectors.toList());
        Collections.sort(list, (a, b) -> {
            //身高从低到高，身高相同体重从轻到重，体重相同维持原来顺序
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return a[2] - b[2];
                } else {
                    return a[1] - b[1];
                }
            } else {
                return a[0] - b[0];
            }
        });
        return list.stream().map(i -> String.valueOf(i[2])).collect(Collectors.joining());
    }
}
