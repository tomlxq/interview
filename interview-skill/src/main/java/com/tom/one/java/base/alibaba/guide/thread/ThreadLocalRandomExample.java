package com.tom.one.java.base.alibaba.guide.thread;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 【推荐】避免 Random 实例被多线程使用，虽然共享该实例是线程安全的，但会因竞争同一 seed
 * 导致的性能下降。
 * 说明：Random 实例包括 java.util.Random 的实例或者 Math.random()的方式。
 * 正例：在 JDK7 之后，可以直接使用 API ThreadLocalRandom，而在 JDK7 之前，需要编码保证每个线
 * 程持有一个单独的 Random 实例。
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class ThreadLocalRandomExample {
    public static void main(String[] args) {
        ThreadLocalRandom t = ThreadLocalRandom.current();
    }


}
