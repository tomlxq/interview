package com.example;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class QueueDemoTest {
    QueueDemo demo;

    @Before
    public void setUp() throws Exception {
        log.info("init queue data");
        demo = new QueueDemo(10);
        for (int i = 0; i < 10; i++) {
            long value = RandomUtils.nextLong(10000, 20000);
            log.info("{}", value);
            demo.insert(value);
        }
    }

    @Test
    public void testFun() {
        log.info("queue is full", demo.isFull());
        log.info("delete by loop");
        while (!demo.isEmpty()) {
            log.info("{}", demo.remove());
        }
        log.info("queue is empty", demo.isEmpty());
    }
}