package com.cedar.design.pattern.structural.facade;

/**
 * @author zhangnan
 * @date 2020-06-28 9:45
 * @description
 */
public class PointsPaymentService {

    public boolean pay(PointsGift pointsGift) {
        // 扣减积分
        System.out.println("支付" + pointsGift.getName() + "积分成功");
        return true;
    }
}
