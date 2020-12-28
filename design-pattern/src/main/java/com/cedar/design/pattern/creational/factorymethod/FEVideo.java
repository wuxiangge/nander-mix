package com.cedar.design.pattern.creational.factorymethod;

/**
 * @author zhangnan
 * @className FEVideo
 * @date 2020-04-03 10:50
 * @description
 */
public class FEVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制FE视频");
    }
}
