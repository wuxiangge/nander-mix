package com.cedar.concurrency.art.pattern.creational.abstractfactory;

/**
 * @author zhangnan
 * @className CourseFactory
 * @date 2020-04-03 11:12
 * @description
 */
public interface CourseFactory {

    Video getVideo();

    Article getArticle();
}
