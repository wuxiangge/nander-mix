package com.cedar.concurrency.art.pattern.creational.simplefactory;

/**
 * @author zhangnan
 * @className Test
 * @date 2020-04-01 19:51
 * @description
 */
public class ReflectTest {

    public static void main(String[] args) {

        ReflectVideoFactory videoFactory = new ReflectVideoFactory();
        Video video = videoFactory.getVideo(JavaVideo.class);
        if (video == null) {
            return;
        }
        video.produce();
    }
}
