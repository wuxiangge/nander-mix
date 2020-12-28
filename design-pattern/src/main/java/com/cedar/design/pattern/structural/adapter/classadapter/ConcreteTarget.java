package com.cedar.design.pattern.structural.adapter.classadapter;

/**
 * @author zhangnan
 * @date 2020-06-30 9:10
 * @description
 */
public class ConcreteTarget implements Target {

    @Override
    public void request() {
        System.out.println("ConcreteTarget 目标方法");
    }
}
