package com.tom.huawei;

import java.util.*;
import java.util.stream.Collectors;

public class ConcatArrayDemo {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int len = sc.nextInt();
            int arySize = sc.nextInt();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < arySize; i++) {
                list.add(sc.next());
            }
            ConcatArrayDemo cad = new ConcatArrayDemo();
            System.out.println(cad.func(list, len));
        }
    }

    private void processLine(String line1, List<Queue<String>> list) {
        String[] tmp = line1.split(",");
        Queue<String> objects = new LinkedList<>();
        for (String c : tmp) {
            objects.add(c);
        }
        list.add(objects);
    }

    public String func(List<String> list3, int len) {
        List<Queue<String>> list = new ArrayList<Queue<String>>();
        for (String line : list3) {
            processLine(line, list);
        }

        List<String> list2 = new ArrayList<String>();
        int count = 0;
        while (count < list.size()) {
            for (Queue<String> line : list) {
                if (line.size() >= len) {
                    for (int i = 0; i < len; i++) {
                        list2.add(line.poll());
                    }
                } else if (line.size() < len && line.size() > 0) {
                    int cur = line.size();
                    for (int i = 0; i < cur; i++) {
                        list2.add(line.poll());
                    }
                } else {
                    count++;
                }
            }

        }
        return list2.stream().collect(Collectors.joining(","));
    }
}
