package com.cedar.concurrency.art.pattern.structural.facade;

/**
 * @author zhangnan
 * @date 2020-06-28 9:49
 * @description
 */
public class ShippingService {

    public String shipGift(PointsGift pointsGift) {
        // 物流系统的对接逻辑
        System.out.println(pointsGift.getName() + "进入物流系统");
        String shippingOrderId = "666";
        return shippingOrderId;
    }
}
