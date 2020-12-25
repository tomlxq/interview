package com.tom.two.design.strategy.pattern;

import com.tom.one.java.base.alibaba.guide.cnt.Man;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class UglyStrategy implements IStrategy{
    Man man;
    public UglyStrategy(Man man) {
        this.man=man;
    }

    @Override
    public void operate() {
        if(!this.man.isUgly()){
            return;
        }
        System.out.println("本姑娘是外貌协会的资深会员");
        return;
    }
}
