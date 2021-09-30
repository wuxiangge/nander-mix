package com.cedar.concurrency.art;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangnan
 * @date 2021/1/21 11:31
 */
public class ReentrantLockExample {

    int a = 0;

    ReentrantLock lock = new ReentrantLock();

    public void write() {
        Condition condition = lock.newCondition();
        lock.lock();

        try {
            condition.await();
            a++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void reader() {
        lock.lock();
        try {
            int i = a;
            System.out.println(i);
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    example.reader();
                    example.write();
                }
            }).start();
        }
    }


}
