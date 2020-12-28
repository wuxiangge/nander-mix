package com.cedar.design.pattern.creational.builder;

/**
 * @author zhangnan
 * @className CourseBuilder
 * @date 2020-04-03 11:41
 * @description
 */
public abstract class CourseBuilder {

    public abstract void builderCourseName(String courseName);

    public abstract void builderCoursePPT(String coursePPT);

    public abstract void builderCourseVideo(String courseVideo);

    public abstract void builderCourseArticle(String courseArticle);

    public abstract void builderCourseQA(String courseQA);

    public abstract Course makeCourse();

}
