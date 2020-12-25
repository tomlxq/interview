package com.tom.one.java.base.alibaba.guide.lock;

import org.junit.Assert;
import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class ThreadCasTest {
    private static int count = 0;

    @Test
    public void testNoCas() {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //每个线程让count自增100次
                    for (int i = 0; i < 100; i++) {
                        count++;
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //因为这个程序是线程不安全的，所以造成的结果count值可能小于200
        System.out.println(count);
    }

    /**
     * 同步锁之后，count自增的操作变成了原子性操作，所以最终的输出一定是count=200，代码实现了线程安全。
     */
    @Test
    public void testCas() {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //每个线程让count自增100次
                    for (int i = 0; i < 100; i++) {
                        synchronized (ThreadCas.class) {
                            count++;
                        }
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count);
        Assert.assertEquals(200, count);
    }
}