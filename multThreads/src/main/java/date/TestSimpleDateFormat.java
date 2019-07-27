package date;

import java.text.SimpleDateFormat;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/7/27
 */
public class TestSimpleDateFormat {
    //(1)创建单例实例
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        // (2)创建多个线程，并启动
        for (int i = 0; i < 10; ++i) {
            Runnable runnable = () -> {
                try {
                    // (3)使用单例日期实例解析文本
                    System.out.println(sdf.parse("2017-12-13 15:17:27"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            // (4)启动线程
            new Thread(runnable).start();
        }
    }
}
