package com.cedar.concurrency.art;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangnan
 * @date 2021/1/22 10:22
 */
public class Shutdown {


    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "Count Thread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);

        countThread.interrupt();


        Runner two = new Runner();
        countThread = new Thread(two, "Count Thread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);

        two.cancel();

    }

    private static class Runner implements Runnable {
        private long i;

        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }


        public void cancel() {
            on = false;
        }
    }
}
