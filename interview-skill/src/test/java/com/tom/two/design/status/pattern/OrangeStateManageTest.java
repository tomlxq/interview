package com.tom.two.design.status.pattern;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class OrangeStateManageTest {
    @Test
    public void useState() {
        // 具体使用状态
        Orange cyanOrange = new CyanOrange();
        // 创建环境
        OrangeStateManage orangeStateManage = new OrangeStateManage();
        // 设置状态并执行
        orangeStateManage.setState(cyanOrange);
        orangeStateManage.print();
    }
}