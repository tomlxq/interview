package com.tom.one.java.base;

import org.apache.commons.math3.util.MathUtils;
import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/8
 */
public class BinarySys {
    @Test
    public void name() {
        int i=35;
        final String s = Integer.toBinaryString(128);
        System.out.printf("binary:%s\n",s);
        final String s2 = Integer.toBinaryString(-35);
        System.out.printf("binary:%s\n",s2);
        System.out.printf(Integer.toBinaryString(127));
        //人  150 岁之内  tinyint unsigned  1  无符号值：0 到 255
        System.out.printf("binary:%f\n",Math.pow(2,8)-1);
        //龟  数百岁  smallint unsigned  2  无符号值：0 到 65535
        System.out.printf("binary:%f\n",Math.pow(2,8*2)-1);
        //恐龙化石  数千万年  int unsigned  4  无符号值：0 到约 43 亿
        System.out.printf("binary:%f\n",Math.pow(2,8*4)-1);
        //太阳  约 50 亿年  bigint unsigned  8  无符号值：0 到约 10 的 19 次方
        System.out.printf("binary:%f\n",Math.pow(2,8*8)-1);


    }
}
