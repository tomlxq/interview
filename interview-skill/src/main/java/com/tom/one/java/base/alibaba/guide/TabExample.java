package com.tom.one.java.base.alibaba.guide;

import com.tom.one.java.base.domain.UserDO;

import java.util.List;
import java.util.Objects;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public class TabExample {
    /**
     * 【强制】相同参数类型，相同业务含义，才可以使用 Java 的可变参数，避免使用 Object 。
     * 说明：可变参数必须放置在参数列表的最后。（建议开发者尽量不用可变参数编程）
     * @param type
     * @param ids
     * @return
     */
    public List<UserDO> listUsers(String type, Long... ids){
       return null;
    }

    /**
     * 【强制】 Object 的 equals 方法容易抛空指针异常，应使用常量或确定有值的对象来调用 equals 。
     * 正例："test".equals(object);
     * 反例：object.equals("test");
     * 说明：推荐使用 JDK7 引入的工具类 java.util.Objects#equals(Object a, Object b)
     * 【强制】所有整型包装类对象之间值的比较，全部使用 equals 方法比较。
     * 【强制】任何货币金额，均以最小货币单位且整型类型来进行存储。
     * @param object
     * @return
     */
    public boolean  isTest(String object){
         boolean equals = "test".equals(object);
         boolean test = Objects.equals("test", object);
        return equals;
    }

    public static void main(String[] args) {
// 缩进 4 个空格
        String say = "hello";
// 运算符的左右必须有一个空格
        int flag = 0;
// 关键词 if 与括号之间必须有一个空格，括号内的 f 与左括号，0 与右括号不需要空格
        if (flag == 0) {
            System.out.println(say);
        }
// 左大括号前加空格且不换行；左大括号后换行
        if (flag == 1) {
            System.out.println("world");
// 右大括号前换行，右大括号后有 else，不用换行
        } else {
            System.out.println("ok");
// 在右大括号后直接结束，则必须换行
        }
        double first = 3.2d;
        int second = (int) first + 2;

        StringBuilder sb = new StringBuilder();
// 超过 120 个字符的情况下，换行缩进 4 个空格，并且方法前的点号一起换行
        sb.append("yang").append("hao")
                .append("chen")
                .append("chen")
                .append("chen");
    }
}
