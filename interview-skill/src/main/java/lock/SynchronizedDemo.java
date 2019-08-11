package lock;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/10
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {

        }
        test();
    }

    private static synchronized void test() {
    }
}
