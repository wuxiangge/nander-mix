package com.cedar.concurrency.art.pattern.structural.adapter.objectadapter;

/**
 * @author zhangnan
 * @date 2020-06-30 12:41
 * @description 通过组合的方式 将被代理的方法委托给目标类去调用
 */
public class Adapter implements Target {

    private Adapted adapted = new Adapted();

    @Override
    public void request() {
        adapted.adaptedRequest();
    }
}
