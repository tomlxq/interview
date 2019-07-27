package lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 由于synchronized是独占锁，导致同时调用getVal方法读取val值的线程竞争独占锁，这降低了并发度，这时候可以降低锁的范围，让读写锁分离。
 *
 * @author TomLuo
 * @date 2019/7/27
 */
public class SafeCountLock {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private int val;

    public int getVal() {
        readLock.lock();
        try {
            return val;
        } finally {
            readLock.unlock();

        }
    }

    public void inc() {
        writeLock.lock();
        try {
            ++val;
        } finally {
            writeLock.unlock();

        }
    }
}
