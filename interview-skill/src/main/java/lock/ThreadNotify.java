package lock;

import java.util.concurrent.locks.Lock;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/11
 */
public class ThreadNotify extends Thread {
    private Object lock;

    public ThreadNotify(Object object) {
        this.lock = object;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开始执行ThreadNotify");
            lock.notify();
            System.out.println("结束执行ThreadNotify");
        }
    }
}
