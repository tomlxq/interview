package bug;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/7/27
 */
public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(16, 30,
                30L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(false);
                t.setUncaughtExceptionHandler((thread, e) -> System.out.println(e.getMessage()));
                return t;
            }
        }, new ThreadPoolExecutor.DiscardOldestPolicy());
        threadPoolExecutor.submit(() -> System.out.println(Thread.currentThread().getName()));
        threadPoolExecutor.shutdown();
        findJavaExecutorsBug();
    }

    /**
     * Java包中预置的线程池有以下几种：
     * newSingleThreadExecutor；
     * newFixedThreadPool：
     * newCachedThreadPool：
     * newScheduledThreadPool：
     * 但在阿里巴巴的Java开发中是不建议甚至禁止使用Java预置线程池的。
     * 代码利用循环，无限添加runnable的实现，但是由于单一线程的阻塞队列是没有边界的，会导致添加的对象过多，耗尽内存资源。
     * 因此阿里巴巴开发手册是明确禁止使用Java预置线程池的。
     */
    private static void findJavaExecutorsBug() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (; ; ) {
            executorService.submit(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(30L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
