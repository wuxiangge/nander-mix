package com.cedar.concurrency.art.pattern.creational.abstractfactory;

/**
 * @author zhangnan
 * @className Main
 * @date 2020-04-03 11:25
 * @description
 */
public class Main {

    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Article article = courseFactory.getArticle();
        Video video = courseFactory.getVideo();
        article.produce();
        video.produce();
    }
}
