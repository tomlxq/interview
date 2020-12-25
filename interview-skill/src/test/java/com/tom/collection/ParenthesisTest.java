package com.tom.collection;


import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/4
 */

public class ParenthesisTest {
    @Test
    public void name() {
        while (true) {
            String s = new Scanner(System.in).next();
            final String[] split = s.split(",");
            if (split.length != 2) {
                System.out.println(false);
                continue;
            }
            String str = split[0];
            int len = Integer.valueOf(split[1]);
            if (len <= 0) {
                System.out.println(false);
                continue;
            }
            Parenthesis parenthesis = new Parenthesis();
            System.out.println(parenthesis.chkParenthesis(str, len));

        }
    }
}
