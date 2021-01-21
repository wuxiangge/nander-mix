package com.cedar.concurrency.art.pattern.creational.prototype.abstractprototype;

/**
 * @author zhangnan
 * @date 2020-06-27 19:48
 * @description
 */
public abstract class A implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
