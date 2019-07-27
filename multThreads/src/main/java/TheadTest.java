/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/7/27
 */
public class TheadTest {
    public static void main(String[] args) {
        PrimeThead primeThead = new PrimeThead();
        primeThead.setName("Runnable1");
        primeThead.start();
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName() + " runnable run.");
        Thread thread = new Thread(runnable, "Runnable2");
        thread.run();
    }

    static class PrimeThead extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Thread Run");
        }
    }
}
