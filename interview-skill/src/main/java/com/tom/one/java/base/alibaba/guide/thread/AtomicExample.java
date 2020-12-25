package com.tom.one.java.base.alibaba.guide.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 【参考】 volatile 解决多线程内存不可见问题。对于一写多读，是可以解决变量同步问题，但
 * 是如果多写，同样无法解决线程安全问题。
 * 说明：如果是 count++操作，使用如下类实现：AtomicInteger count = new AtomicInteger();
 * count.addAndGet(1); 如果是 JDK8，推荐使用 LongAdder 对象，比 AtomicLong 性能更好（减少乐观
 * 锁的重试次数）。
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class AtomicExample {

    AtomicInteger count = new AtomicInteger();
   // new LongAdder()
}
