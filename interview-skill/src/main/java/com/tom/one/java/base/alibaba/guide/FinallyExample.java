package com.tom.one.java.base.alibaba.guide;

/**
 * 【强制】不要在 finally 块中使用 return。
 * 说明：try 块中的 return 语句执行成功后，并不马上返回，而是继续执行 finally 块中的语句，如果此处存
 * 在 return 语句，则在此直接返回，无情丢弃掉 try 块中的返回点。
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class FinallyExample {
    private int x = 0;
    public int checkReturn() {
        try {
// x 等于 1，此处不返回
            return ++x;
        } finally {
// 返回的结果是 2
            return ++x;
        }
    }

}
