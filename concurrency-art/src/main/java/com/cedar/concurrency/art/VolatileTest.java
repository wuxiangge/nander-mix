package com.cedar.concurrency.art;

/**
 * @author zhangnan
 * @date 2021/1/20 15:03
 */
public class VolatileTest {

    private volatile Integer instance;

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
    }
}
