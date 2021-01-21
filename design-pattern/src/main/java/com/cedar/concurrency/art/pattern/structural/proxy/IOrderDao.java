package com.cedar.concurrency.art.pattern.structural.proxy;

/**
 * @author zhangnan
 * @date 2020-04-12 18:33
 * @description
 */
public interface IOrderDao {

    /**
     * 插入订单
     *
     * @param order
     * @return
     */
    int insert(Order order);
}
