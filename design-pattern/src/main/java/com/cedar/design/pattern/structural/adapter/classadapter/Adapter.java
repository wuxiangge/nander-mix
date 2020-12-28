package com.cedar.design.pattern.structural.adapter.classadapter;

/**
 * @author zhangnan
 * @date 2020-06-30 9:14
 * @description
 */
public class Adapter extends Adapted implements Target {

    @Override
    public void request() {
        super.adaptedRequest();
    }
}
