package com.tom.demo;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/10
 */
public class Java5Demo {
    public static void main(String[] args) {
        String[] hello = new String[]{"hello", "world"};
        String[] hello2 = ary("hello", "world");
        Integer[] data = ary(1, 2, 3, 4, 5);
        //formatter.format(Locale.FRANCE, "e = %+10.4f", Math.E);
    }

    private static <T> T[] ary(T... values) {
        return values;
    }
}
