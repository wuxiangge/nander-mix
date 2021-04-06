package com.cedar.concurrency.art;

/**
 * @author zhangnan
 * @date 2021/1/22 10:36
 */
public class Synchronized {


    public static void main(String[] args) {

        synchronized (Synchronized.class) {
            System.out.println("test");
        }

        m();
    }

    private static synchronized void m() {
        System.out.println("m");
    }

}
