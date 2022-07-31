package com.tom.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PythagoreanDemo {
    private int ac(int a, int b) {
        int mod = 2;
        while (mod != 0) { //3 4 5
            mod = a % b;
            a = b;
            b = mod;
        }
        return a;
    }

    public String func(int n, int m) {
        List<String> list = new ArrayList<>();
        for (int i = n; i < m + 1; i++) {
            for (int j = i + 1; j < m + 1; j++) {
                for (int k = j + 1; k < m + 1; k++) {
                    if (i * i + j * j == k * k && ac(i, j) == 1 && ac(j, k) == 1 && ac(i, k) == 1) {
                        list.add(String.format("%d %d %d", i, j, k));
                    }
                }
            }
        }
        if (list.size() == 0) {
            return "Na";
        }
        return list.stream().collect(Collectors.joining("\n"));
    }
}
