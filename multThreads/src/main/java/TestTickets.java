/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/7/27
 */
public class TestTickets {
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
                System.out.println(Thread.currentThread().getName() + " sell ticket: " + tickets);
                tickets--;
            }
            System.out.println(Thread.currentThread().getName() + " sell out: ");
        }
    }
}
