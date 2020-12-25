package com.tom.order;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/376ede61d9654bc09dd7d9fa9a4b0bcd?orderByHotValue=0&questionTypes=000100&mutiTagIds=639&page=1&onlyReference=false
 * 来源：牛客网
 * <p>
 * 请设计一个复杂度为O(n)的算法，计算一个未排序数组中排序后相邻元素的最大差值。
 * <p>
 * 给定一个整数数组A和数组的大小n，请返回最大差值。保证数组元素个数大于等于2小于等于500。
 * <p>
 * 测试样例：
 * [9,3,1,10],4
 * 1 3 9 10
 * 返回：6
 *
 * @author TomLuo
 * @date 2020/3/7
 */

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class MaxDivision {
    public int findMaxDivision(int[] A, int n) {

        List<Integer> integers = new ArrayList<>();
        Arrays.stream(A).forEach(v -> {
            integers.add(v);
        });
        integers.sort((o1, o2) -> {
            return o1 - o2;
        });
        int off = 0;
        for (int cur = 0; cur < n; cur++) {
            if (cur == 0) {
                continue;
            }
            final int max = Integer.max(integers.get(cur), integers.get(cur - 1));
            final int min = Integer.min(integers.get(cur), integers.get(cur - 1));
            off = (max - min) > off ? (max - min) : off;
        }
        return off;
    }
}
