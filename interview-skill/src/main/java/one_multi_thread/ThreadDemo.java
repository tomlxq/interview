package one_multi_thread;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/10
 */
public class ThreadDemo {
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

    public static void main(String[] args) throws InterruptedException {
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
    }
}
