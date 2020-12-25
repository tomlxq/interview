package com.tom.two.design.strategy.pattern;

import com.tom.one.java.base.alibaba.guide.cnt.Man;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class BadTemperStrategy implements IStrategy{
    Man man;
    public BadTemperStrategy(Man man) {
        this.man=man;
    }

    @Override
    public void operate() {
        if(!this.man.isBadTemper()){
            return;
        }
        System.out.println("银河有多远，你就给我滚多远");
        return;
    }
}
