package com.tom.one.java.base.alibaba.guide;

/**
 * 【强制】避免在子父类的成员变量之间、或者不同代码块的局部变量之间采用完全相同的命名，
 * 使可理解性降低。
 * 说明：子类、父类成员变量名相同，即使是 public 类型的变量也能够通过编译，另外，局部变量在同一方
 * 法内的不同代码块中同名也是合法的，这些情况都要避免。对于非 setter/getter 的参数名称也要避免与成
 * 员变量名称相同。
 * 反例：
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public class ConfusingName {
    public int stock;

    // 非 setter/getter 的参数名称，不允许与本类成员变量同名
    public void get(String alibaba) {
        boolean condition = true;
        if (condition) {
            final int money = 666;
// ...
        }
        for (int i = 0; i < 10; i++) {
// 在同一方法体中，不允许与其它代码块中的 money 命名相同
            final int money = 15978;
// ...
        }
    }
}

class Son extends ConfusingName {
    // 不允许与父类的成员变量名称相同
    public int stock;
}
