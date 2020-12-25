package com.tom.one.java.base.alibaba.guide.thread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public class LockExampleTest {
    @Test(expected = IllegalArgumentException.class)
    public void testLockOK() {
        Lock lock = new ReentrantLock();
// ...
        lock.lock();
        try {
            doSomething();
            doOthers();
        } finally {
            lock.unlock();
        }
    }


    @Test(expected = IllegalMonitorStateException.class)
    public void testLockErr() {
        Lock lock = new ReentrantLock();
        // ...
        try {
            // 如果此处抛出异常，则直接执行 finally 代码块
            doSomething();
            // 无论加锁是否成功，finally 代码块都会执行
            lock.lock();
            doOthers();
        } finally {
            lock.unlock();
        }
    }

    private void doOthers() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doSomething() {
        try {
            TimeUnit.SECONDS.sleep(3);
            throw new IllegalArgumentException("failed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}