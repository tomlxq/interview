package com.example.task;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Component
public class TaskDemo {
    Runnable runnableTask = () -> {
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    Callable<String> callableTask = () -> {
        TimeUnit.MILLISECONDS.sleep(300);
        return "Task's execution";
    };
    ExecutorService executorService =
            new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>());
    ScheduledExecutorService executorService2 = Executors
            .newSingleThreadScheduledExecutor();

    public void task2() {
        Future<String> resultFuture =
                executorService2.schedule(callableTask, 1, TimeUnit.SECONDS);
        ScheduledFuture<?> resultFuture2 = executorService2
                .scheduleAtFixedRate(runnableTask, 100, 450, TimeUnit.MILLISECONDS);
        executorService2.scheduleWithFixedDelay(runnableTask, 100, 150, TimeUnit.MILLISECONDS);
    }

    public void task1() {


        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        executorService.execute(runnableTask);
        Future<String> future =
                executorService.submit(callableTask);
        String result = null;
        try {
            result = future.get(200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        try {
            String result2 = executorService.invokeAny(callableTasks);
            List<Future<String>> futures = executorService.invokeAll(callableTasks);
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
