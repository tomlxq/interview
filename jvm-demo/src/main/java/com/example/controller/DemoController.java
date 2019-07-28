package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/7/27
 */
@RestController
public class DemoController {
    private static List<int[]> bigObj = new ArrayList<>();
    private static List<char[]> bigCharObj = new ArrayList<>();

    private int[] generate1M() {
        return new int[1024 * 512];
    }

    private char[] generate1CharM() {
        return new char[1024 * 1024];
    }

    @GetMapping("/jvm-info")
    public List<GarbageCollectorMXBean> info() {
        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        return garbageCollectorMXBeans;
    }

    @GetMapping("/jvm-error")
    public void error() {
        for (int i = 0; i < 1000; ++i) {
            if (i == 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("start = [" + new Date() + "]");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    TimeUnit.MILLISECONDS.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            bigObj.add(generate1M());
        }
    }

    @GetMapping("/jvm-io")
    public void io() throws IOException {
        while (true) {
            File file = new File("/tmp/iotest/" + System.currentTimeMillis());
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            for (int i = 0; i < 10000; i++) {
                fileOutputStream.write(new byte[256]);
            }
            fileOutputStream.flush();


        }
    }


    @GetMapping("/jvm-lock")
    public void lock() {
        DeadLock dl = new DeadLock();
        new Thread(() -> {
            dl.m1();
        }).start();

        new Thread(() -> {
            dl.m2();
        }).start();
    }

    static class DeadLock {
        private final static Lock loc1 = new ReentrantLock();
        private final static Lock loc2 = new ReentrantLock();

        public void m1() {
            synchronized (loc1) {
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("m1 start");
                synchronized (loc2) {
                    System.out.println("m1 end");
                }
            }
        }

        public void m2() {
            synchronized (loc2) {
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("m2 start");
                synchronized (loc1) {
                    System.out.println("m2 end");
                }
            }
        }
    }

}
