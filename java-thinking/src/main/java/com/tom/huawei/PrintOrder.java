package com.tom.huawei;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

@Slf4j
public class PrintOrder {
    public String func(String line) {
        int[] ary = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        //优先队列存储一个数组，数组的第一个元素是数值，第二个元素是出现顺序，构建大顶堆，相同元素的按出现顺序排列
        PriorityQueue<int[]> priQue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < ary.length; i++) {
            //元素入队
            queue.offer(ary[i]);
            //元素以及相应的顺序入队
            priQue.offer(new int[]{ary[i], i});
        }
        int[] res = new int[ary.length];
        int idx = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            int[] priQue1 = priQue.poll();
            if (poll == priQue1[0]) {
                res[priQue1[1]] = idx++;
            } else {
                priQue.offer(priQue1);
                queue.offer(poll);
            }
        }
        return Arrays.stream(res).boxed().map(String::valueOf).collect(Collectors.joining(","));
    }


}
