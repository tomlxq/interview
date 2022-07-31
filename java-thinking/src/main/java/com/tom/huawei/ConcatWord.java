package com.tom.huawei;

import java.util.*;
import java.util.stream.Collectors;

public class ConcatWord {
    public static void main(String[] args) {
        //"worddwordda", 0,6,"word dd da dc dword d"
        try (Scanner sc = new Scanner(System.in)) {
            int idx = sc.nextInt();
            int n = sc.nextInt();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.next());
            }
            ConcatWord cw = new ConcatWord();
            System.out.println(cw.func(idx, list.stream().collect(Collectors.joining(" "))));
        }
    }

    public String func(int num, String line) {
        List<String> ary = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
        List<String> dp = new ArrayList<String>();
        dp.add(ary.get(num));
        ary.remove(ary.get(num));
        while (ary.size() > 0) {
            List<String> cache = new ArrayList<String>();
            for (String w : ary) {
                String last = dp.get(dp.size() - 1);
                if (w.charAt(0) == last.charAt(last.length() - 1)) {
                    cache.add(w);
                }
            }
            if (cache.size() > 0) {
                Collections.sort(cache, (a, b) -> b.length() == a.length() ? a.compareTo(b) : b.length() - a.length());
                dp.add(cache.get(0));
                ary.remove(cache.get(0));
            } else {
                break;
            }
        }
        return dp.stream().collect(Collectors.joining());
    }
}
