package lock;

/**
 * 但是volatile只能保证内存可见性，不能保证原子性
 *
 * @author TomLuo
 * @date 2019/7/27
 */
public class UnSafeCount {
    private volatile int val;

    public int getVal() {
        return val;
    }

    public void inc() {
        ++val;
    }
}
