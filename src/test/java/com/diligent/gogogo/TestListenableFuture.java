package com.diligent.gogogo;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureTask;

import java.util.concurrent.ExecutionException;

/**
 * @version: v1.0
 * @author: zhangty
 * @date: 2022/7/29 10:50
 */
public class TestListenableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ListenableFuture<?> future = new ListenableFutureTask(() -> {
            int f1 = 0;
            for (int i = 0; i < 10000; i++) {
                f1 += i;
            }
            System.out.println(f1);
            return "好了";
        });

        new ThreadPoolTaskExecutor().execute((Runnable) future);

    }
}