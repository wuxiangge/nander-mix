package com.cedar.concurrency.art.pattern.behavioral.chainofresponsibility;

/**
 * @author zhangnan
 * @date 2020-04-16 22:45
 * @description
 */
public abstract class Approver {

    /**
     * 包含一个自己类型的
     */
    protected Approver approver;

    public void setNextApprover(Approver approver) {
        this.approver = approver;
    }

    public abstract void deploy(Course course);
}
