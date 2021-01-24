package com.cedar.concurrency.art.pattern.structural.adapter.classadapter;

/**
 * @author zhangnan
 * @date 2020-06-30 12:35
 * @description 类适配器模式 强调继承
 */
public class Test {

    public static void main(String[] args) {
        Target concreteTarget = new ConcreteTarget();
        concreteTarget.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }
}
