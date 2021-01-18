package com.cedar.core;

/**
 * @author zhangnan
 * @date 2021/1/14 15:40
 */
public interface InterfaceTest<T> {


//    int compareTo(T t);


    default int compareTo(T t) {
        return 0;
    }

    public static void test() {
        return;
    }


}
