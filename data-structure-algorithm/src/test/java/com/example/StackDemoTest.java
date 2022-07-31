package com.example;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class StackDemoTest {
    StackDemo demo;

    @Before
    public void setUp() throws Exception {
        demo = new StackDemo(100);
        log.info("init stack data");
        for (int i = 0; i < 50; i++) {
            int value = RandomUtils.nextInt(0, 10000);
            log.info("{}", value);
            demo.push(value);
        }
    }

    @Test
    public void funTest() {
        log.info("last one {}", demo.peek());
        log.info("isFull {}", demo.isFull());
        log.info("stack pop data");
        while (!demo.isEmpty()) {
            log.info("{}", demo.pop());
        }

    }
}