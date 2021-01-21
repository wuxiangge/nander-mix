package com.cedar.concurrency.art.pattern.creational.singleton;

/**
 * @author zhangnan
 * @date 2020-04-11 11:37
 * @description 懒汉模式改进方案，在静态方法上加 synchronized 关键字 锁的类的class文件 ，同步锁消耗资源，锁class范围大
 * <p>
 * double check 双重检查
 */
public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    private LazySingleton() {

    }

    public synchronized static LazySingleton getInstance() {
        if (lazySingleton == null) {
            // 线程不安全
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
