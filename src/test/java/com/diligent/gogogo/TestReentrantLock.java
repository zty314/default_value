package com.diligent.gogogo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version: v1.0
 * @author: zhangty
 * @date: 2022/8/9 15:39
 */
@Slf4j
public class TestReentrantLock {

    static final ReentrantLock lock = new ReentrantLock();

    @Test
    public void testLock() {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            pool.execute(() -> {
                try {
                    testUnlock(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }


    public void testUnlock(int count) throws InterruptedException {
        System.out.println(" Thread= " + Thread.currentThread().getName());
        try {
            boolean tryLock = lock.tryLock(100, TimeUnit.MILLISECONDS);

            if (count > 0 && tryLock) {
                try {
                    System.out.println("lock count=" + count + " Thread= " + Thread.currentThread().getName());
                    count--;
                    testUnlock(count);
                } finally {
                    System.out.println("unlock count=" + count + " Thread= " + Thread.currentThread().getName());

                }
            }
        } finally {
            lock.unlock();
        }
    }

    @Test
    public void testLock2() throws InterruptedException {
        boolean tryLock;
        new Thread(()->{
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        TimeUnit.SECONDS.sleep(2);
        try {
            tryLock = lock.tryLock();
            if (tryLock) {
//                try {
                TimeUnit.SECONDS.sleep(1);
//                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(lock.hasQueuedThreads());
            System.out.println(lock.getQueueLength());
            System.out.println(lock.isHeldByCurrentThread());
            lock.unlock();
        }

        System.out.println("success");
    }
}