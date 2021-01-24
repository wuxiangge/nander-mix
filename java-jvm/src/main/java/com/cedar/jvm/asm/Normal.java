package com.cedar.jvm.asm;

import java.util.concurrent.TimeUnit;

public class Normal {

    public void m1() {
        System.out.println("now in method m1----->");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
