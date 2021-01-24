package com.cedar.concurrency.art.pattern.structural.decorator.v2;

/**
 * @author zhangnan
 * @date 2020-06-28 13:12
 * @description
 */
public class SausageDecorator extends AbstractDecorator {

    public SausageDecorator(AbstractBatterCake abstractBatterCake) {
        super(abstractBatterCake);
    }

    @Override
    protected void doSomething() {
        super.doSomething();
    }

    @Override
    protected String getDescription() {
        return super.getDescription() + " 加一根香肠";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }
}
