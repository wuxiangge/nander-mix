package com.cedar.concurrency.art.pattern.creational.builder;

/**
 * @author zhangnan
 * @className Coach
 * @date 2020-04-03 12:08
 * @description
 */
public class Coach {

    private CourseBuilder courseBuilder;

    public void setCourseBuilder(CourseBuilder courseBuilder) {
        this.courseBuilder = courseBuilder;
    }

    public Course makeCourse(String courseName,
                             String coursePPT,
                             String courseVideo,
                             String courseArticle,
                             String courseQA) {
        this.courseBuilder.builderCourseName(courseName);
        this.courseBuilder.builderCourseArticle(courseArticle);
        this.courseBuilder.builderCoursePPT(coursePPT);
        this.courseBuilder.builderCourseVideo(courseVideo);
        this.courseBuilder.builderCourseQA(courseQA);
        return this.courseBuilder.makeCourse();
    }
}
