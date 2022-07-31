package com.tom.huawei;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MiniStopBus {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            MiniStopBus msb = new MiniStopBus();
            System.out.println(msb.func(sc.nextLine()));
        }
    }

    public int func(String line) {
        int[] ary = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        String join = Arrays.stream(ary).boxed().map(String::valueOf).collect(Collectors.joining());
        String s = join.replaceAll("111", "3").replaceAll("11", "2");

        int total = 0;
        for (char c : s.toCharArray()) {
            if (c == '3' || c == '2' || c == '1') {
                total++;
            }
        }
        return total;
    }

    public int func2(String line) {
        int[] ary = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        String[] join = Arrays.stream(ary).boxed().map(String::valueOf).collect(Collectors.joining()).split("0");
        int total = 0;
        for (String c : join) {
            int size = c.length();
            int big = size / 3;
            int mid = (size - big * 3) / 2;
            int small = size - big * 3 - mid * 2;
            total += big + mid + small;
        }
        return total;
    }
}
