package com.cedar.concurrency.art.pattern.structural.facade;

/**
 * @author zhangnan
 * @date 2020-06-28 11:05
 * @description
 */
public class Test {
    public static void main(String[] args) {
        PointsGift pointsGift = new PointsGift("T恤");
        GiftExchangeService giftExchangeService = new GiftExchangeService();
        giftExchangeService.giftExchange(pointsGift);
    }
}
