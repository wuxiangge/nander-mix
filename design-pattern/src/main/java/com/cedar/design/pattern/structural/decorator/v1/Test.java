package com.cedar.design.pattern.structural.decorator.v1;

/**
 * @author zhangnan
 * @date 2020-06-28 11:45
 * @description
 */
public class Test {
    public static void main(String[] args) {
        BatterCake batterCake = new BatterCake();
        System.out.println(batterCake.getDesc() + "销售价格：" + batterCake.cost());

        BatterCake batterCakeWhitEgg = new BatterCakeWhitEgg();
        System.out.println(batterCakeWhitEgg.getDesc() + "销售价格：" + batterCakeWhitEgg.cost());

        BatterCake batterCakeWhitEggSausage = new BatterCakeWhitEggSausage();
        System.out.println(batterCakeWhitEggSausage.getDesc() + "销售价格：" + batterCakeWhitEggSausage.cost());

    }
}
