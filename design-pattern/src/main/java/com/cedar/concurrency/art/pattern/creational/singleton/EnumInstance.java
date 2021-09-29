package com.cedar.concurrency.art.pattern.creational.singleton;

/**
 * @author zhangnan
 * @date 2020-04-11 13:38
 * @description
 */
public enum EnumInstance {

    INSTANCE;

    public static EnumInstance getInstance() {
        return INSTANCE;
    }


    /**
     *
     * 00-24   1       3
     *
     * 02-07   2       2
     *
     * 03-09   3       5
     *
     *
     *
     *
     *
     * 00-02
     * 02-03
     * 03-07
     * 07-09
     * 09-24
     *
     *
     * 00 02 03 07 09 24
     *
     *
     *
     */

}
