package com.tom.huawei;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class StudentCompare {
    /**
     * 示例一
     * 输入
     * 100 10
     * 95 96 97 98 99 101 102 103 104 105
     * 输出
     * 99 101 98 102 97 103 96 104 95 105
     * <p>
     * 说明 小明身高100
     * 班级学生10个 身高分别为
     *
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            StudentCompare scc = new StudentCompare();
            System.out.println(scc.compareStudent(sc.nextLine(), sc.nextLine()));
        }
    }

    public static void main2(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int h = scanner.nextInt();
            int n = scanner.nextInt();
            List<Integer> highs = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                highs.add(scanner.nextInt());
            }
            solution(h, highs);
        }
    }

    private static void solution(int h, List<Integer> highs) {
        highs.sort((h1, h2) -> {
            int diff1 = Math.abs(h1 - h);
            int diff2 = Math.abs(h2 - h);
            return diff1 == diff2 ? h1 - h2 : diff1 - diff2;
        });

        for (int i = 0; i < highs.size(); i++) {
            System.out.print(highs.get(i));
            if (i != highs.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    @NotNull
    public String compareStudent(String line1, String line2) {
        int h = Integer.parseInt(line1.split(" ")[0]);
        List<Integer> list = Arrays.stream(line2.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        list.sort((h1, h2) -> {
                    int d1 = Math.abs(h1 - h);
                    int d2 = Math.abs(h2 - h);
                    return d1 == d2 ? h1 - h2 : d1 - d2;
                }
        );
        return list.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    public String compareStudent3(String line1, String line2) {
        String[] split = line1.split("\\s+");
        String[] highs = line2.split("\\s+");
        List<String> list = new ArrayList<>(highs.length);
        int h = Integer.parseInt(split[0]);
        Collections.addAll(list, highs);
        Collections.sort(list, (o1, o2) -> {
            int h1 = Integer.parseInt(o1);
            int h2 = Integer.parseInt(o2);
            int d1 = Math.abs(h1 - h);
            int d2 = Math.abs(h2 - h);
            return d1 == d2 ? h1 - h2 : d1 - d2;
        });
        return list.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    public String compareStudent2(String line1, String line2) {
        int h = Integer.parseInt(line1.split(" ")[0]);
        List<Integer> res = Arrays.stream(line2.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        res.sort((Integer o1, Integer o2) -> {
            int d1 = o1 - h > 0 ? o1 - h : h - o1;
            int d2 = o2 - h > 0 ? o2 - h : h - o2;
            if (d1 == d2) {
                return o1 - o2;
            } else {
                return d1 - d2;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.append(i).append(" ");
        }
        return sb.toString().trim();
    }
}
