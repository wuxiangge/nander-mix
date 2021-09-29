package com.cedar.concurrency.art;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangnan
 * @date 2021/9/26
 */
public class ThreadLocalExample implements Runnable {

    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));


    private static final ThreadLocal<AtomicInteger> nextInteger = ThreadLocal.withInitial(AtomicInteger::new);

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        formatter.set(new SimpleDateFormat());
        System.out.println(Thread.currentThread().getName() + formatter.get().toPattern());
    }


    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = nextInteger.get();
        System.out.println(atomicInteger);
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(threadLocalExample, i + "");
            Thread.sleep(new Random().nextInt(1000));
            thread.start();
        }
    }


}
