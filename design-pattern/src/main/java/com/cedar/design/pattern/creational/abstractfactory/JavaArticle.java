package com.cedar.design.pattern.creational.abstractfactory;

/**
 * @author zhangnan
 * @className Video
 * @date 2020-04-01 19:48
 * @description
 */
public class JavaArticle extends Article {
    @Override
    public void produce() {
        System.out.println("编写Java课程手记");
    }
}
