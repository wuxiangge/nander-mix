package com.cedar.concurrency.art.pattern.creational.singleton;

import java.io.Serializable;

/**
 * @author zhangnan
 * @date 2020-04-11 12:52
 * @description 饿汉式模式 序列化反序列化
 */
public class HungrySingleton implements Serializable, Cloneable {


    private final static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    private Object readResolve() {
        return hungrySingleton;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }
}
