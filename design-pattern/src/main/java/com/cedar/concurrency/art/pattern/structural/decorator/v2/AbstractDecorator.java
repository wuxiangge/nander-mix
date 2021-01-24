package com.cedar.concurrency.art.pattern.structural.decorator.v2;

/**
 * @author zhangnan
 * @date 2020-06-28 11:57
 * @description
 */
public abstract class AbstractDecorator extends AbstractBatterCake {

    private AbstractBatterCake abstractBatterCake;

    public AbstractDecorator(AbstractBatterCake abstractBatterCake) {
        this.abstractBatterCake = abstractBatterCake;
    }

    /**
     * 钩子方法
     */
    protected void doSomething() {
        // 钩子方法
    }

    @Override
    protected String getDescription() {
        return this.abstractBatterCake.getDescription();
    }

    @Override
    protected int cost() {
        return this.abstractBatterCake.cost();
    }
}
