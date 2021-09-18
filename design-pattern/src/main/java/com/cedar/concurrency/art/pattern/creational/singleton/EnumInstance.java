package com.cedar.concurrency.art.pattern.creational.singleton;

/**
 * @author zhangnan
 * @date 2020-04-11 13:38
 * @description
 */
public enum EnumInstance {

    INSTANCE;

    public static EnumInstance getInstance() {
        return INSTANCE;
    }

}
