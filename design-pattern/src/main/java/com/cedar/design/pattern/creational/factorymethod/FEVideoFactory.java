package com.cedar.design.pattern.creational.factorymethod;

/**
 * @author zhangnan
 * @className JavaVideoFactory
 * @date 2020-04-03 0:25
 * @description
 */
public class FEVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new FEVideo();
    }
}
