package com.cedar.concurrency.art.pattern.structural.facade;

/**
 * @author zhangnan
 * @date 2020-06-28 9:29
 * @description
 */
public class PointsGift {

    private String name;


    public PointsGift(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
