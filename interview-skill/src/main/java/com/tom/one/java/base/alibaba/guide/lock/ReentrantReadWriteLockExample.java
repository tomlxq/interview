package com.tom.one.java.base.alibaba.guide.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class ReentrantReadWriteLockExample {
    public static void main(String[] args) {
        /**
         * 锁降级：从写锁变成读锁；锁升级：从读锁变成写锁。
         * ReentrantReadWriteLock支持锁升级，不支持锁降级
         * 会发生锁降级，从写锁降级成读锁。但没有正确的释放写锁，不会自动释放当前线程获取的写锁，仍然需要显示的释放，否则别的线程永远也获取不到写锁。
         */
        ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();
        System.out.println(3);
        reentrantReadWriteLock.writeLock().lock();
        System.out.println(2);
        reentrantReadWriteLock.readLock().lock();
        System.out.println(1);
/**
 * 测试锁升级的代码，在读锁还没释放的情况下去申请写锁
 */
            ReadWriteLock reentrantReadWriteLock2=new ReentrantReadWriteLock();
            System.out.println(3);
            reentrantReadWriteLock2.readLock().lock();
            System.out.println(2);
            reentrantReadWriteLock2.writeLock().lock();
            System.out.println(1);

    }
}
