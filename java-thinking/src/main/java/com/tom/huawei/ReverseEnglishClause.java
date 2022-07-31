package com.tom.huawei;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseEnglishClause {
    public String func(String input, int beginIdx, int endIdx) {
        String[] split = input.trim().split("\\s+");
        if (split.length == 1) {
            //指定反转区间只有一个单词，或无有效单词则统一输出EMPTY。
            return "EMPTY";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            if (beginIdx <= i && i <= endIdx) {
                List<String> collect = IntStream.rangeClosed(beginIdx, endIdx).mapToObj(k -> split[k]).collect(Collectors.toList());
                collect = Lists.reverse(collect);
                sb.append(collect.stream().collect(Collectors.joining(" "))).append(" ");
                i = endIdx;
            } else {
                sb.append(split[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
