package com.cedar.concurrency.art.pattern.structural.proxy;

/**
 * @author zhangnan
 * @date 2020-04-12 18:33
 * @description
 */
public interface IOrderService {
    /**
     * 保存订单
     *
     * @param order
     * @return
     */
    int saveOrder(Order order);
}
