package com.cedar.core;

import java.util.function.Predicate;

/**
 * @author zhangnan
 * @date 2021/1/14 15:45
 */
public class InterfaceTestImpl implements InterfaceTest {

    @Override
    public int compareTo(Object o) {
        return 0;
    }


    public void init() {

        Predicate predicate1 = new Predicate() {
            @Override
            public boolean test(Object o) {
                System.out.println(this.toString());
                return false;
            }
        };

        predicate1.test(3);

        Predicate predicate = e -> {
            System.out.println(this.toString());
            return false;
        };

        predicate.test(5);


    }


    @Override
    public String toString() {
        System.out.println("------------>");
        return super.toString();
    }

    public static void main(String[] args) {
        InterfaceTestImpl test = new InterfaceTestImpl();
        test.init();
    }
}
