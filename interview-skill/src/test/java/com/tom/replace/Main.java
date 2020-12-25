package com.tom.replace;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/3897c2bcc87943ed98d8e0b9e18c4666?orderByHotValue=0&questionTypes=000100&mutiTagIds=639&page=1&onlyReference=false
 * 来源：牛客网
 * <p>
 * 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.
 * <p>
 * 输入描述:
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 * <p>
 * <p>
 * 输出描述:
 * 对于每一次询问操作，在一行里面输出最高成绩.
 * 示例1
 * 输入
 * 5 7
 * 1 2 3 4 5
 * Q 1 5
 * U 3 6
 * Q 3 4
 * Q 4 5
 * U 4 5
 * U 2 9
 * Q 1 5
 * 输出
 * 5
 * 6
 * 5
 * 9
 *
 * @author TomLuo
 * @date 2020/3/4
 */
public class Main {
    public static void main(String[] args) {
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            final String[] s = scanner.next().split(" ");
            int stuNo = Integer.valueOf(s[0]);
            int opeNo = Integer.valueOf(s[1]);
            final String[] scores = scanner.next().split(" ");
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 1; i <= stuNo; i++) {
                map.put(i, Integer.valueOf(scores[i - 1]));
            }
            LinkedList<Integer> list = new LinkedList<>();
            while (opeNo > 0) {
                final String[] acts = scanner.next().split(" ");
                String act = acts[0];
                Integer begin = Integer.valueOf(acts[1]);
                Integer end = Integer.valueOf(acts[2]);
                //处理查询
                if (act.equals("Q")) {
                    Integer max = map.get(begin);
                    for (int i = begin + 1; i <= end; i++) {
                        max = map.get(i) > max.intValue() ? map.get(i) : max.intValue();
                    }
                    list.add(max);
                    opeNo--;
                    continue;
                }
                if (act.equals("U")) {
                    map.put(begin, end);
                    opeNo--;
                    continue;
                }
            }
            list.stream().forEach(System.out::println);
        }
    }
}
