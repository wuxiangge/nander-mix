package com.cedar.concurrency.art.pattern.principle.liskovsubstitution.methodoutput;

/**
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.method());

    }
}
