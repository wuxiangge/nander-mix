package com.cedar.concurrency.art.pattern.creational.abstractfactory;

/**
 * @author zhangnan
 * @className Video
 * @date 2020-04-01 19:48
 * @description
 */
public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制python课程视频");
    }
}
