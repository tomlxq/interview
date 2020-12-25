package com.tom.one.java.base.alibaba.guide.cnt;

import com.tom.two.design.strategy.pattern.BadTemperStrategy;
import com.tom.two.design.strategy.pattern.Context;
import com.tom.two.design.strategy.pattern.PoorStrategy;
import com.tom.two.design.strategy.pattern.UglyStrategy;

/**
 * 5. 【强制】在高并发场景中，避免使用”等于”判断作为中断或退出的条件。
 * 说明：如果并发控制没有处理好，容易产生等值判断被“击穿”的情况，使用大于或小于的区间判断条件
 * 来代替。
 * Java 开发手册
 * 22/59
 * 反例：判断剩余奖品数量等于 0 时，终止发放奖品，但因为并发处理错误导致奖品数量瞬间变成了负数，
 * 这样的话，活动无法终止。
 * 6. 【推荐】当某个方法的代码总行数超过 10 行时，return / throw 等中断逻辑的右大括号后均
 * 需要加一个空行。
 * 说明：这样做逻辑清晰，有利于代码阅读时重点关注。
 * 7. 【推荐】表达异常的分支时，少用 if-else 方式 ，这种方式可以改写成：
 * if (condition) {
 * ...
 * return obj;
 * }
 * // 接着写 else 的业务逻辑代码;
 * 说明：如果非使用 if()...else if()...else...方式表达逻辑，避免后续代码维护困难，请勿超过 3 层。
 * 正例：超过 3 层的 if-else 的逻辑判断代码可以使用卫语句、策略模式、状态模式等来实现，其中卫语句
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class ManyIfElseExample {
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
    public void findBoyfriend2 (Man man) {
        Context context;
        //拿到妙计
        context = new Context(new UglyStrategy(man));
        context.operate();
        //拿到妙计
        context = new Context(new PoorStrategy(man));
        context.operate();
        //拿到妙计
        context = new Context(new BadTemperStrategy(man));
        context.operate();
        System.out.println("可以先交往一段时间看看");
    }
    public void findBoyfriend3 (Man man) {

    }
    public static void main(String[] args) {


    }
}
