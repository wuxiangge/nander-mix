package com.cedar.concurrency.art.pattern.creational.factorymethod;

/**
 * @author zhangnan
 * @className JavaVideo
 * @date 2020-04-01 19:49
 * @description
 */
public class JavaVideo extends Video {

    @Override
    public void produce() {
        System.out.println("录制Java视频");
    }
}
