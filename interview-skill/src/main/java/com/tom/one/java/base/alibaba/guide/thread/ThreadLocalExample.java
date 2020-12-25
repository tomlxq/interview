package com.tom.one.java.base.alibaba.guide.thread;

import com.tom.one.java.base.domain.UserDO;

/**
 *【强制】必须回收自定义的 ThreadLocal 变量，尤其在线程池场景下，线程经常会被复用，
 * 如果不清理自定义的 ThreadLocal 变量，可能会影响后续业务逻辑和造成内存泄露等问题。
 * 尽量在代理中使用 try-finally 块进行回收。
 *
 * 【参考】ThreadLocal 对象使用 static 修饰，ThreadLocal 无法解决共享对象的更新问题。
 * 说明：这个变量是针对一个线程内所有操作共享的，所以设置为静态变量，所有此类实例共享此静态变量，
 * 也就是说在类第一次被使用时装载，只分配一块存储空间，所有此类的对象(只要是这个线程内定义的)都可
 * 以操控这个变量。
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public class ThreadLocalExample {
    static ThreadLocal objectThreadLocal = new ThreadLocal();
    public static void main(String[] args) {
        UserDO userInfo = new UserDO();
        objectThreadLocal.set(userInfo);
        try {
            // ...
        } finally {
            objectThreadLocal.remove();
        }
    }
}
