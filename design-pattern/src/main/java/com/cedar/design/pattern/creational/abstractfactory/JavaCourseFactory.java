package com.cedar.design.pattern.creational.abstractfactory;

/**
 * @author zhangnan
 * @className CourseFactoty
 * @date 2020-04-03 11:12
 * @description
 */
public class JavaCourseFactory implements CourseFactory {

    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
