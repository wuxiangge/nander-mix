package com.cedar.design.pattern.structural.proxy;

/**
 * @author zhangnan
 * @date 2020-04-12 18:34
 * @description
 */
public class IOrderDaoImpl implements IOrderDao {

    @Override
    public int insert(Order order) {
        System.out.println("Dao层添加Order成功");
        return 1;
    }
}
