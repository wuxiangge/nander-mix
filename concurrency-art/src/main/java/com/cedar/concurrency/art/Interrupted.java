package com.cedar.concurrency.art;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangnan
 * @date 2021/1/22 9:42
 */
public class Interrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");

        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);

        sleepThread.interrupt();

        busyThread.interrupt();

        System.out.println("SleepThread interrupted is" + sleepThread.isInterrupted());

        System.out.println("BusyThread interrupted is" + busyThread.isInterrupted());

        SleepUtils.second(10);
        System.out.println("1111");
    }


    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println("33333333333333333");
                }
            }
        }
    }


    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("---------");
            }
        }
    }
}
