package com.tom.huawei;

import com.google.common.collect.Lists;

import java.util.List;

public class MetaDemo {
    /**
     * 0
     * asdbuiodevauufgh
     */
    public int fun(int flaws, String input) {
        List<Character> chars = Lists.newArrayList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int calLen = 0;
        int max = 0;
        for (int read = 0; read < input.length(); read++) {
            if (chars.contains(input.charAt(read))) {
                calLen++;
            } else if (flaws > 0) {
                calLen++;
                flaws--;
            } else {
                max = Math.max(max, calLen);
                calLen = 0;
            }
        }
        return max;
    }
}
