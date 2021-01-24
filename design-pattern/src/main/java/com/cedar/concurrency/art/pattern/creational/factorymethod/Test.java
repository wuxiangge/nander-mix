package com.cedar.concurrency.art.pattern.creational.factorymethod;

/**
 * @author zhangnan
 * @className Test
 * @date 2020-04-01 19:51
 * @description
 */
public class Test {

    public static void main(String[] args) {

        VideoFactory videoFactory = new JavaVideoFactory();
        VideoFactory videoFactory1 = new PythonVideoFactory();
        VideoFactory videoFactory2 = new FEVideoFactory();
        Video video = videoFactory.getVideo();
        video.produce();
    }
}
