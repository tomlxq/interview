package com.tom.collection;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;
import java.util.Stack;

/**
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * <p>
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 *
 * @author TomLuo
 * @date 2020/3/3
 */
@Slf4j
public class Parenthesis {
    /**
     * 1)遇到(往栈里放 (
     * 2)遇到）往弹出栈,弹出来前检查是否为空，如果为空，则返回false
     * 3)如果是其它内容，直接报错
     * 4)最后栈为空，则通过true，不为空，则不通过false
     */
    public boolean chkParenthesis(String A, int n) {
        Stack stack = new Stack();
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '(') {
                stack.push('(');
            } else if (A.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            } else {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {


    }
}
