package lock;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/11
 */
public class ThreadWait extends Thread {
    private Object lock;

    public ThreadWait(Object object) {
        this.lock = object;
    }

    @Override
    public void run() {
        synchronized (lock) {

            try {
                System.out.println("开始执行ThreadWait");
                lock.wait();
                System.out.println("结束执行ThreadWait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Object o=new Object();
        ThreadWait thread1 = new ThreadWait(o);
        ThreadNotify thread2 = new ThreadNotify(o);
        thread1.start();
        thread2.start();
    }
}
