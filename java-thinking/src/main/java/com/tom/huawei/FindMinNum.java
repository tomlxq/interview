package com.tom.huawei;

import java.util.Deque;
import java.util.LinkedList;

public class FindMinNum {
    public String func(String line, int k) {
        Deque<Character> queue = new LinkedList<>();

        for (Character digit : line.toCharArray()) {
            while (!queue.isEmpty() && k > 0 && queue.peekLast() > digit) {
                queue.pollLast();
                k--;
            }
            queue.offerLast(digit);
        }
        //当前数字都比最后一位大
        for (int i = 0; i < k; i++) {
            queue.pollFirst();
        }
        StringBuffer sb = new StringBuffer();
        boolean leadNum = true;
        while (!queue.isEmpty()) {
            Character c = queue.pollFirst();
            if (c == '0' && leadNum) {
                if (queue.isEmpty()) {
                    sb.append(c);
                }
                continue;
            }
            leadNum = false;
            sb.append(c);
        }
        return sb.toString();
    }
}
