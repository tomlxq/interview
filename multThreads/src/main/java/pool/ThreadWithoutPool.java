package pool;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/7/27
 */
public class ThreadWithoutPool {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; ++i) {
            Demo demo = new Demo(i);
            Runnable runnable = () -> demo.doTask();
            new Thread(runnable, "线程" + i).start();
        }
    }

    static class Demo {
        private int index;

        public Demo(int index) {
            this.index = index;
        }

        public void doTask() {
            System.out.println("i:" + index + " doTask() called");
        }
    }
}
