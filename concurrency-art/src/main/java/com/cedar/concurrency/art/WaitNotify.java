package com.cedar.concurrency.art;


import java.util.concurrent.TimeUnit;

/**
 * @author zhangnan
 * @date 2021/1/22 11:04
 */
public class WaitNotify {

    static boolean flag = true;

    static Object lock = new Object();


    public static void main(String[] args) throws InterruptedException {
        new Thread(new Wait(), "WaitThread").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(new Notify(), "NotifyThread").start();

    }

    static class Wait implements Runnable {
        @Override
        public void run() {

            synchronized (lock) {

                while (flag) {
                    System.out.println(Thread.currentThread() + " flag is true");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread() + " flag is false");
        }
    }


    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread() + "hold lock");
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }

            synchronized (lock) {
                System.out.println(Thread.currentThread() + "hold lock again");
                SleepUtils.second(5);
            }

        }
    }
}
