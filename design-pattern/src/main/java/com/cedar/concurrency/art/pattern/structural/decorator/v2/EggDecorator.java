package com.cedar.concurrency.art.pattern.structural.decorator.v2;

/**
 * @author zhangnan
 * @date 2020-06-28 12:01
 * @description
 */
public class EggDecorator extends AbstractDecorator {

    public EggDecorator(AbstractBatterCake abstractBatterCake) {
        super(abstractBatterCake);
    }

    @Override
    protected void doSomething() {
        super.doSomething();
    }

    @Override
    protected String getDescription() {
        return super.getDescription() + " 加一个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost() + 1;
    }
}
