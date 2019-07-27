package pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/7/27
 */
public class ThreadWithPool {
    static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(8, 8, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());

    public static void main(String[] args) {
        for (int i = 0; i < 1000; ++i) {
            Demo demo = new Demo(i);
            Runnable runnable = () -> demo.doTask();
            threadPool.execute(runnable);
        }
        threadPool.shutdown();
    }

    static class Demo {
        private int index;

        public Demo(int index) {
            this.index = index;
        }

        public void doTask() {
            System.out.println("i:" + index + " doTask() called");
            System.out.println("当前激活的线程个数（正在执行任务的线程）：" + threadPool.getActiveCount());
            System.out.println("已经完成的任务个数：" + threadPool.getCompletedTaskCount());
            System.out.println("所有任务个数，包含已经完成的、正在执行的和队列里面缓存的：" + threadPool.getTaskCount());
        }
    }
}
