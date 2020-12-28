package com.cedar.design.pattern.structural.proxy.staticproxy;

import com.cedar.design.pattern.structural.proxy.IOrderService;
import com.cedar.design.pattern.structural.proxy.IOrderServiceImpl;
import com.cedar.design.pattern.structural.proxy.Order;

/**
 * @author zhangnan
 * @date 2020-04-12 18:40
 * @description
 */
public class OrderServiceStaticProxy {

    private IOrderService iOrderService;

    public int saveOrder(Order order) {
        beforeMethod(order);
        iOrderService = new IOrderServiceImpl();
        int result = iOrderService.saveOrder(order);
        afterMethod();
        return result;
    }

    private void beforeMethod(Order order) {
        int userId = order.getUserId();
        int dbRouter = userId % 2;
        System.out.println("静态代理分配到【db" + dbRouter + "】处理数据");
        System.out.println("静态代理 before code");
    }

    private void afterMethod() {
        System.out.println("静态代理 after code");
    }


}
