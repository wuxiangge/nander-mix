package com.cedar.concurrency.art.pattern.principle.dependenceinversion;

/**
 * Created by geely
 */
public class FECourse implements ICourse {
    @Override
    public void studyCourse() {
        System.out.println("Geely在学习FE课程");
    }

}
