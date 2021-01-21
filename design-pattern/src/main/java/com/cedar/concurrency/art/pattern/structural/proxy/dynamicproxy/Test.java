package com.cedar.concurrency.art.pattern.structural.proxy.dynamicproxy;

import com.cedar.concurrency.art.pattern.structural.proxy.IOrderService;
import com.cedar.concurrency.art.pattern.structural.proxy.IOrderServiceImpl;
import com.cedar.concurrency.art.pattern.structural.proxy.Order;

/**
 * @author zhangnan
 * @date 2020-04-12 23:24
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(1);

        IOrderService orderService = (IOrderService) new OrderServiceDynamicProxy(new IOrderServiceImpl()).bind();

        orderService.saveOrder(order);

    }
}
