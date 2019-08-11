package com.tom.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Wrapper;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/10
 */
public class Java7Demo extends Object {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("D:/1.txt");
            // java.lang.AutoCloseable  since 1.7
            // java.io.InputStream 继承了AutoCloseable
            //public interface Connection  extends Wrapper, AutoCloseable {}
        } catch (FileNotFoundException | RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public interface EchoService {
        /**
         * @param message 消息
         */
        @Deprecated(since = "1.1")
        void echo(String message);
        void echo(String message, String... others);
    }

    /**
     * 1.2
     */
    public class EchoServiceImpl implements EchoService {
        /**
         * 1.2 remove @Overide
         * @param message 消息
         */
        @Override
        public void echo(String message) {
        }

        @Override
        public void echo(String message, String... others) {

        }
    }
}
