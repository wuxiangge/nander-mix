package com.cedar.concurrency.art;

/**
 * @author zhangnan
 * @date 2021/1/20 13:34
 */
public class DeadLockDemo {

    private static String A = "A";

    private static String B = "B";

    public static void main(String[] args) throws InterruptedException {
        new DeadLockDemo().deadLock();
    }

    private void deadLock() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.currentThread().sleep(20000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                synchronized (B) {
                    System.out.println("1");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });


        t1.start();
        Thread.sleep(100);
        t2.start();
    }
}
