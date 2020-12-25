package com.tom.one.java.base.alibaba.guide.log;

import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
@Slf4j
public class LogExample {
    public static void main(String[] args) {
        Long id=1L;
        String symbol="zhangshan";
        log.debug("Processing trade with id: {} and symbol: {}", id, symbol);
    }
}
