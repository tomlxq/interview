package com.tom.one.java.base.alibaba.guide.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 乐观锁
 * 乐观锁，总是乐观地假设最好的情况，每次去拿数据的时候都认为别人不会修改这个数据，所以不会上锁，只会要对数据进行更新时判断一下在此期间(拿到数据到更新的期间)别人有没有去更改这个数据，可以使用版本号机制和CAS算法实现。
 *
 * CAS
 * CAS（Compare And Swap）是一种常见的“乐观锁”，大部分的CPU都有对应的汇编指令，它有三个操作数：内存地址V，旧值A，新值B。只有当前内存地址V上的值是A，B才会被写到V上，否则操作失败。
 * Java从5.0开始引入了对CAS的支持，与之对应的是 java.util.concurrent.atomic 包下的AtomicInteger、AtomicReference等类，它们提供了基于CAS的读写操作和并发环境下的内存可见性。
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public class AtomicReferenceFieldUpdater {
    public static void main(String[] args) {
        AtomicInteger integer=new AtomicInteger(123);
        int a=integer.addAndGet(321);//+321
        System.out.println(a);//结果为444
    }
}
