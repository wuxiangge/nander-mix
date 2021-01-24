package com.cedar.concurrency.art.pattern.structural.decorator.v2;

/**
 * @author zhangnan
 * @date 2020-06-28 11:54
 * @description 抽象实体的最简单实实现
 */
public class NormalBatterCake extends AbstractBatterCake {

    @Override
    protected String getDescription() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
