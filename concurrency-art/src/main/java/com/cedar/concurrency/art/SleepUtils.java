package com.cedar.concurrency.art;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangnan
 * @date 2021/1/21 18:28
 */
public class SleepUtils {

    public static final void second(long second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
