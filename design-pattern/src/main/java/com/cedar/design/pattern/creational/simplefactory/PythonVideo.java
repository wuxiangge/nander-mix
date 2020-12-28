package com.cedar.design.pattern.creational.simplefactory;

/**
 * @author zhangnan
 * @className JavaVideo
 * @date 2020-04-01 19:49
 * @description
 */
public class PythonVideo extends Video {

    @Override
    public void produce() {
        System.out.println("录制Python视频");
    }
}
