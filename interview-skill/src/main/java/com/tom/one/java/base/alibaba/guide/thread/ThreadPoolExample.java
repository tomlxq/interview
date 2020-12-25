
package com.tom.one.java.base.alibaba.guide.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


/**
 * 3. 【强制】线程资源必须通过线程池提供，不允许在应用中自行显式创建线程。
 * 说明：线程池的好处是减少在创建和销毁线程上所消耗的时间以及系统资源的开销，解决资源不足的问题。
 * 如果不使用线程池，有可能造成系统创建大量同类线程而导致消耗完内存或者“过度切换”的问题。
 * 4. 【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这
 * 样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
 * 说明：Executors 返回的线程池对象的弊端如下：
 * 1） FixedThreadPool 和 SingleThreadPool：
 * 允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
 * 2） CachedThreadPool：
 * 允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public class ThreadPoolExample {
    public static void main(String[] args) {
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5,
                2, TimeUnit.MINUTES,
                new LinkedBlockingQueue<Runnable>(10),
                new UserThreadFactory("Factory_one"),
                new ThreadPoolExecutor.CallerRunsPolicy());
        IntStream.rangeClosed(1, 100).forEach(idx -> {
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println("begin task"+idx+" "+Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("finished task"+idx+" "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

    }
}
