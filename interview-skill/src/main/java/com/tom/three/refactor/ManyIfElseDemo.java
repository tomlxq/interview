package com.tom.three.refactor;

import com.tom.one.java.base.alibaba.guide.cnt.Man;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class ManyIfElseDemo {
    public void findBoyfriend (Man man) {
        if (man.isUgly()) {
            System.out.println("本姑娘是外貌协会的资深会员");
            return;
        }
        if (man.isPoor()) {
            System.out.println("贫贱夫妻百事哀");
            return;
        }
        if (man.isBadTemper()) {
            System.out.println("银河有多远，你就给我滚多远");
            return;
        }
        System.out.println("可以先交往一段时间看看");
    }






}
