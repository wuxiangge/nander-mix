package com.cedar.concurrency.art.pattern.structural.facade;

/**
 * @author zhangnan
 * @date 2020-06-28 9:37
 * @description
 */
public class QualifyService {

    public boolean isAvailable(PointsGift pointsGift) {
        System.out.println("校验" + pointsGift.getName() + "积分资格通过，库存通过");
        return true;
    }

}
