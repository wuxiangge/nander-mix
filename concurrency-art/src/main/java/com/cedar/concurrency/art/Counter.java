package com.cedar.concurrency.art;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangnan
 * @date 2021/1/20 18:39
 */
public class Counter {

    private AtomicInteger atomicI = new AtomicInteger(0);

    private int i = 0;

    public static void main(String[] args) {

        final Counter cas = new Counter();


        ArrayList<Thread> threads = new ArrayList<>(600);
        long start = System.currentTimeMillis();

        for (int j = 0; j < 100; j++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            threads.add(thread);
        }


        for (Thread thread : threads) {
            thread.start();
        }


        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println(cas.i);

        System.out.println(cas.atomicI.get());


        System.out.println(System.currentTimeMillis() - start);

    }


    private void safeCount() {
        for (; ; ) {
            int i = atomicI.get();

            boolean success = atomicI.compareAndSet(i, ++i);
            if (success) {
                break;
            }
        }
    }

    private void count() {
        i++;
    }


}
