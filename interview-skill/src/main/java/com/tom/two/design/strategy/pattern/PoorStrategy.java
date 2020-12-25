package com.tom.two.design.strategy.pattern;

import com.tom.one.java.base.alibaba.guide.cnt.Man;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class PoorStrategy implements IStrategy{
    Man man;
    public PoorStrategy(Man man) {
        this.man=man;
    }

    @Override
    public void operate() {
        if(!this.man.isBadTemper()){
            return;
        }
        System.out.println("贫贱夫妻百事哀");
        return;
    }
}
