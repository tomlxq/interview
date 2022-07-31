package com.tom.huawei;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Martion {
    public static void main(String[] args) {
        Martion m = new Martion();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            System.out.println(m.func(input));
        }
        sc.close();
    }

    public int func(String input) {
        //优先算最后#
        int index = input.lastIndexOf("#");
        if (index != -1) {
            String left = input.substring(0, index);
            String right = input.substring(index + 1);
            int res = 2 * func(left) + 3 * func(right) + 4;
            return res;
        }
        //优先算第一$
        index = input.lastIndexOf("$");
        if (index != -1) {
            String left = input.substring(0, index);
            String right = input.substring(index + 1);
            int res = 3 * func(left) + func(right) + 2;
            return res;
        }
        return Integer.parseInt(input);
    }

    public int fun2(String input) {
        // 无符号数
        List<Integer> idxList = IntStream.range(1, input.length()).filter(i -> input.charAt(i) == '#' || input.charAt(i) == '$').boxed().collect(Collectors.toList());
        // 按操作符 分隔字符串
        Stack stack = new Stack();
        int s = 0;
        for (int e : idxList) {
            stack.push(Integer.parseInt(input.substring(s, e)));
            stack.push(input.charAt(e));
            s = e + 1;
        }
        stack.push(Integer.parseInt(input.substring(s)));
        // 计算 优先级高的$ f"3*{x}+{y}+2")
        Stack r_stack = new Stack();
        while (!stack.isEmpty()) {
            String item = stack.pop().toString();
            if (item.charAt(0) == '$') {
                int x = Integer.parseInt(stack.pop().toString());
                int y = Integer.parseInt(r_stack.pop().toString());
                stack.push(3 * x + y + 2);
            } else {
                r_stack.push(item);
            }
        }
        stack = r_stack;
        // 计算 2*{x}+3*{y}+4"
        int x = Integer.parseInt(stack.pop().toString());
        while (!stack.isEmpty()) {
            stack.pop();
            int y = Integer.parseInt(stack.pop().toString());
            x = 2 * x + 3 * y + 4;
        }
        return x;
    }
}
