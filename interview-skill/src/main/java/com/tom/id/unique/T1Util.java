package com.tom.id.unique;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class T1Util {

    static ExecutorService executor;


    public static void timeTasks(int nThreads, int singleSum, Runnable runnable) throws InterruptedException {
        executor = Executors.newFixedThreadPool(nThreads);

        IntStream.range(0, singleSum).boxed().forEach(id -> executor.submit(runnable));


        executor.awaitTermination(1, TimeUnit.SECONDS);
        executor.shutdown();

    }

}
