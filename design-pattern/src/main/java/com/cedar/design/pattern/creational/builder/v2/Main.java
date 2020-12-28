package com.cedar.design.pattern.creational.builder.v2;

/**
 * @author zhangnan
 * @className Main
 * @date 2020-04-03 12:55
 * @description
 */
public class Main {
    public static void main(String[] args) {
        Course course = new Course.CourseBuilder().buildCourseName("java基础")
                .buildCoursePPT("PPT").buildCourseQA("QA").buildCourseVideo("Video")
                .build();
        System.out.println(course);
    }
}
