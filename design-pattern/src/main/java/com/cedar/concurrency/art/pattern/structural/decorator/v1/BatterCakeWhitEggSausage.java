package com.cedar.concurrency.art.pattern.structural.decorator.v1;

/**
 * @author zhangnan
 * @date 2020-06-28 11:43
 * @description
 */
public class BatterCakeWhitEggSausage extends BatterCakeWhitEgg {
    @Override
    protected String getDesc() {
        return super.getDesc() + "加一根香肠";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }
}
