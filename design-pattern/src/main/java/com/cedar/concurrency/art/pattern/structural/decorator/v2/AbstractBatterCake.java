package com.cedar.concurrency.art.pattern.structural.decorator.v2;

/**
 * @author zhangnan
 * @date 2020-06-28 11:50
 * @description 对实体的抽象描述
 */
public abstract class AbstractBatterCake {

    /**
     * 获取描述
     *
     * @return
     */
    protected abstract String getDescription();

    /**
     * 购买产品花费
     *
     * @return
     */
    protected abstract int cost();
}
