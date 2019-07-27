package scheduler;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/7/27
 */
public class TestTimer {
    // 创建定时器对象
    static Timer timer = new Timer();

    public static void main(String[] args) {
        // 添加任务1,延迟500ms执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("---one Task---");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("error ");
            }
        }, 500);

        // 添加任务2，延迟1000ms执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (; ; ) {
                    System.out.println("---two Task---");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 1000);
    }
}

