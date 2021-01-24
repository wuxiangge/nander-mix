package com.cedar.concurrency.art.pattern.structural.proxy;

/**
 * @author zhangnan
 * @date 2020-04-12 18:36
 * @description
 */
public class IOrderServiceImpl implements IOrderService {

    private IOrderDao iOrderDao;

    @Override
    public int saveOrder(Order order) {
        iOrderDao = new IOrderDaoImpl();
        System.out.println("service层调用Dao层");
        return iOrderDao.insert(order);
    }
}
