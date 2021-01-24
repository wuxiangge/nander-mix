package com.cedar.concurrency.art.pattern.creational.builder;

/**
 * @author zhangnan
 * @className Main
 * @date 2020-04-03 12:15
 * @description
 */
public class Main {

    public static void main(String[] args) {
        CourseBuilder courseBuilder = new CourseActualBuilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(courseBuilder);

        Course course = coach.makeCourse("Java基础",
                "PPT", "视频",
                "文章", "问答");
        System.out.println(course);
    }
}
