package name;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/7/27
 */
public class ThreadWithName {
    public static void main(String[] args) {
        // 订单模块
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("保存订单的线程");
                throw new NullPointerException();
            }
        }, "订单模块");

        // 发货模块
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("保存收货地址的线程");
            }
        }, "发货模块");

        threadOne.start();
        threadTwo.start();
    }
}
