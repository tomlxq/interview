package com.tom.one.java.base;

import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/20
 */
public class FloatDemo {
    @Test
    public void name() {
        float a = 1f;
        float b = 0.9f;

            float f = a -b;
        System.out.println(f);
        System.out.printf("f=%f",f);
        System.out.printf("二进制输出%s",Integer.toBinaryString(1.0f));
        Float.toHexString()
    }
}
