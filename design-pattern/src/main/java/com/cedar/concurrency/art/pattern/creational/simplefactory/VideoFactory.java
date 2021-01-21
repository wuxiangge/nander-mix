package com.cedar.concurrency.art.pattern.creational.simplefactory;

/**
 * @author zhangnan
 * @className VideoFactory
 * @date 2020-04-01 19:54
 * @description 简单工厂 不满足开闭原则；对修改关闭，对扩展开发
 */
public class VideoFactory {

    public Video getVideo(String type) {
        if ("java".equalsIgnoreCase(type)) {
            return new JavaVideo();
        } else if ("python".equalsIgnoreCase(type)) {
            return new PythonVideo();
        }
        return null;
    }
}
