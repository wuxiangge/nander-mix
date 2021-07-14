package com.cedar.concurrency.art.pattern.creational.singleton;

/**
 * @author zhangnan
 * @date 2020-04-11 17:17
 * @description
 */
public class ThreadLocalSingle {

    private ThreadLocalSingle() {

    }

    private static final ThreadLocal<ThreadLocalSingle> threadLocalSingleThreadLocal = ThreadLocal.withInitial(() -> new ThreadLocalSingle());

    public static ThreadLocalSingle getInstance() {
        return threadLocalSingleThreadLocal.get();
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.arch"));
    }
}
