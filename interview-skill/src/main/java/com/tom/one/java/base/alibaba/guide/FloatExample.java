package com.tom.one.java.base.alibaba.guide;

import java.math.BigDecimal;

/**
 * 【强制】任何货币金额，均以最小货币单位且整型类型来进行存储。
 * 【强制】浮点数之间的等值判断，基本数据类型不能用==来比较，包装数据类型不能用 equals来判断。
 * 说明：浮点数采用“尾数+阶码”的编码方式，类似于科学计数法的“有效数字+指数”的表示方式。二进
 * 制无法精确表示大部分的十进制小数，具体原理参考《码出高效》。
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public class FloatExample {
    /**
     * 【强制】禁止使用构造方法 BigDecimal(double) 的方式把 double 值转化为 BigDecimal 对象。
     * 说明：BigDecimal(double)存在精度损失风险，在精确计算或值比较的场景中可能会导致业务逻辑异常。
     * 如：BigDecimal g = new BigDecimal(0.1F); 实际的存储值为：0.10000000149
     * 正例：优先推荐入参为 String 的构造方法，或使用 BigDecimal 的 valueOf 方法，此方法内部其实执行了
     * Double 的 toString，而 Double 的 toString 按 double 的实际能表达的精度对尾数进行了截断。
     * BigDecimal recommend1 = new BigDecimal("0.1");
     * BigDecimal recommend2 = BigDecimal.valueOf(0.1);
     */
    public void initBigDecimal(){
        BigDecimal recommend1 = new BigDecimal("0.1");
        BigDecimal recommend2 = BigDecimal.valueOf(0.1);
    }

    /**
     * 【强制】如上所示 BigDecimal 的等值比较应使用 compareTo()方法，而不是 equals()方法。
     * 说明：equals()方法会比较值和精度 （1.0 与 1.00 返回结果为 false） ，而 compareTo()则会忽略精度。
     */
    public void bigDecimalNum(){
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");
        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);
        if (x.compareTo(y) == 0) {
            System.out.println("true");
        }
    }
    public void compareAB(){
        float a = 1.0F - 0.9F;
        float b = 0.9F - 0.8F;
        float diff = 1e-6F;
        if (Math.abs(a - b) < diff) {
            System.out.println("true");
        }
    }
}
