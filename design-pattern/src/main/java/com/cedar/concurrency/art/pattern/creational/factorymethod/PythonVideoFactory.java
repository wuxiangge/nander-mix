package com.cedar.concurrency.art.pattern.creational.factorymethod;

/**
 * @author zhangnan
 * @className JavaVideoFactory
 * @date 2020-04-03 0:25
 * @description
 */
public class PythonVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
