package com.example;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class PriorityQueueDemoTest {
    PriorityQueueDemo demo;

    @Before
    public void setUp() throws Exception {
        demo = new PriorityQueueDemo(15);
        log.info("init priority queue data");
        for (int i = 0; i < 20; i++) {
            if (!demo.isFull()) {
                long value = RandomUtils.nextLong(10000, 20000);
                log.info("{}", value);
                demo.insert(value);
            }
        }
    }

    @Test
    public void testFun() {
        log.info("Is full {} min value {}", demo.isFull(), demo.peekMin());
        while (!demo.isEmpty()) {
            log.info("remove {}", demo.remove());
        }
        log.info("Is empty {}", demo.isEmpty());
    }

}