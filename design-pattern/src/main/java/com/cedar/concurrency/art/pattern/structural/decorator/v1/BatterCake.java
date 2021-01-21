package com.cedar.concurrency.art.pattern.structural.decorator.v1;

/**
 * @author zhangnan
 * @date 2020-06-28 11:13
 * @description
 */
public class BatterCake {
    protected String getDesc() {
        return "煎饼";
    }

    protected int cost() {
        return 8;
    }
}
