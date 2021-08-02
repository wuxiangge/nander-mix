package com.cedar.concurrency.art.pattern.creational.singleton;

/**
 * @author zhangnan
 * @date 2020-04-11 12:04
 * @description 双重检查 实现单例生成 指令重排序问题 隐患 intra-thread semantics
 */
public class LazyDoubleCheckSingleton {

    /**
     * volatile 缓存一致性
     */
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    private LazyDoubleCheckSingleton() {

    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazyDoubleCheckSingleton == null) {
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();

                    /**
                     * 1 分配内存给这个对象
                     * 2 初始化对象
                     * 3 设置 lazyDoubleCheckSingleton 指向刚分配的内存地址
                     *   intra-thread semantics
                     */
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
