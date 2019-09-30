package lock;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/11
 */
public class VolatileDemo {
    private static volatile VolatileDemo instance;

    public VolatileDemo getInstance() {
        if (null == instance) {
            synchronized (this) {
                if (null == instance) {
                    instance = new VolatileDemo();
                }
            }
        }
        return instance;
    }
}
