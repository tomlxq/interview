package one_multi_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/10
 */
public class ThreadOrderDemo {
    static Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }, "thread1");
    static Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }, "thread2");
    static Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }, "thread3");
    /**
     * FIFO
     */
    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);
        executorService.shutdown();
    }
}
