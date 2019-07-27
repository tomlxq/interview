import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/7/27
 */
public class TestTickets3 {
    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        Thread thread1 = new Thread(tickets::sell, "sellA");
        Thread thread2 = new Thread(tickets::sell, "sellB");
        Thread thread3 = new Thread(tickets::sell, "sellC");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class Tickets {
        int tickets = 10;

        void sell() {
            while (tickets > 0) {
                synchronized (TestTickets.class) {
                    //代码在临界区内加入判断条件，只有票数大于0时，才会进行售票操作，这是常用的双重检验方法。经过双重检验后，运行代码就不会出现无效售票。
                    if (tickets > 0) {
                        System.out.println(Thread.currentThread().getName() + " sell ticket: " + tickets);
                        tickets--;
                    }
                }
                // do something
                try {
                    TimeUnit.MILLISECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " sell out");
        }
    }
}
