package lock;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/7/27
 */
public class SharedValue {
    private volatile int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
