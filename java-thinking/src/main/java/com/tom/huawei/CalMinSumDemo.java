package com.tom.huawei;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CalMinSumDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalMinSumDemo cms = new CalMinSumDemo();
        System.out.println(cms.fun(scanner.nextLine(), scanner.nextLine(), scanner.nextInt()));
    }

    public int fun(String line1, String line2, int count) {
        List<Integer> list1 = Arrays.stream(line1.trim().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(line2.trim().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        List<Integer> list = new ArrayList();
        for (int c1 : list1) {
            for (int c2 : list2) {
                list.add(c1 + c2);
            }
        }
        Collections.sort(list);
        return IntStream.range(0, count).map(i -> list.get(i)).sum();
    }
}
