package com.cedar.design.pattern.creational.singleton;

/**
 * @author zhangnan
 * @date 2020-04-11 11:44
 * @description
 */
public class T implements Runnable {
    @Override
    public void run() {

        StaticInnerClassSingleton lazySingleton = StaticInnerClassSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + " " + lazySingleton);
    }
}
