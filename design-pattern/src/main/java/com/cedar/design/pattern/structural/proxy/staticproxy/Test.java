package com.cedar.design.pattern.structural.proxy.staticproxy;

import com.cedar.design.pattern.structural.proxy.Order;

/**
 * @author zhangnan
 * @date 2020-04-12 22:28
 * @description
 */
public class Test {

    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(1);

        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();

        orderServiceStaticProxy.saveOrder(order);
    }
}
