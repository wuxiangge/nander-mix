package com.cedar.concurrency.art.pattern.creational.simplefactory;

/**
 * @author zhangnan
 * @className VideoFactory
 * @date 2020-04-01 19:54
 * @description 简单工厂 不满足开闭原则；对修改关闭，对扩展开发 使用反射
 */
public class ReflectVideoFactory {

    public Video getVideo(Class<? extends Video> clazz) {
        Video video = null;
        try {
            video = (Video) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return video;
    }
}
