package lock;

/**
 * 由于++val不具有原子性，所以该计数器不是线程安全的，应该保证inc方法是原子性的，这时候synchronized就派上用场了（synchronized保证原子性和内存可见性）。
 *
 * @author TomLuo
 * @date 2019/7/27
 */
public class SafeCount {
    private int val;

    public synchronized int getVal() {
        return val;
    }

    public synchronized void inc() {
        ++val;
    }
}
