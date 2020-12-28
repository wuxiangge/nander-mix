package com.cedar.design.pattern.creational.singleton;

/**
 * @author zhangnan
 * @date 2020-04-11 12:20
 * @description innerclass 对象初始化锁
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {

    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }

    private static class InnerClass {
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }
}
