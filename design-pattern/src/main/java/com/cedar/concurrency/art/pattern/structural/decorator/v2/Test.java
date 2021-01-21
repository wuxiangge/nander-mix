package com.cedar.concurrency.art.pattern.structural.decorator.v2;

/**
 * @author zhangnan
 * @date 2020-06-28 13:15
 * @description 装饰器模式
 */
public class Test {
    public static void main(String[] args) {

        AbstractBatterCake abstractBatterCake;
        abstractBatterCake = new NormalBatterCake();
        abstractBatterCake = new EggDecorator(abstractBatterCake);
        abstractBatterCake = new EggDecorator(abstractBatterCake);
        abstractBatterCake = new SausageDecorator(abstractBatterCake);
        System.out.println(abstractBatterCake.getDescription() + " 销售价格：" + abstractBatterCake.cost());
    }
}
