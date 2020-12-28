package com.cedar.design.pattern.behavioral.chainofresponsibility;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangnan
 * @date 2020-04-16 22:48
 * @description
 */
public class ArticleApprover extends Approver {


    @Override
    public void deploy(Course course) {
        if (StringUtils.isNotBlank(course.getArticle())) {
            System.out.println(course.getName() + "含有手记，批准");
            if (approver != null) {
                approver.deploy(course);
            }
        } else {
            System.out.println("不包含手记，不批准，流程结束");
            return;
        }
    }
}
