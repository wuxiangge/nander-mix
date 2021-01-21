package com.cedar.concurrency.art.pattern.creational.abstractfactory;

/**
 * @author zhangnan
 * @className Video
 * @date 2020-04-01 19:48
 * @description
 */
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Java课程视频");
    }
}
