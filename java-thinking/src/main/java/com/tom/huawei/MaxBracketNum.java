package com.tom.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxBracketNum {
    public int func(String line) {
        Stack<Character> stackOpen = new Stack<>();
        Stack<Character> stackClose = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        int max = 0;
        for (char c : line.toCharArray()) {
            if (map.containsKey(c)) {
                stackOpen.add(c);
                stackClose.add(map.get(c));
            } else if (!stackOpen.isEmpty() && stackClose.contains(c)) {
                int size = stackClose.size();
                max = Math.max(size, max);
                char c1 = stackOpen.pop();
                char c2 = stackClose.pop();
                if (c != c2) {
                    max = 0;
                    break;
                }
            }
        }
        if (stackOpen.size() > 0) {
            max = 0;
        }
        return max;
    }
}
