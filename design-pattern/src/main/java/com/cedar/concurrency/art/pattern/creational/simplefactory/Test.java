package com.cedar.concurrency.art.pattern.creational.simplefactory;

/**
 * @author zhangnan
 * @className Test
 * @date 2020-04-01 19:51
 * @description
 */
public class Test {

    public static void main(String[] args) {

        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo("java");
        video.produce();
    }
}
