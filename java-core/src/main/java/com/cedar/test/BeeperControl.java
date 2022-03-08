package com.cedar.test;

import sun.plugin.dom.core.CDATASection;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author zhangnan
 * @date 2022/2/25
 * @description //TODO
 */
public class BeeperControl {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(100);

    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("beep");
                System.out.println(new Date());
                try {
                    SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 1, 3, SECONDS);

        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                beeperHandle.cancel(true);
            }
        }, 60 * 60, SECONDS);
    }


    public static void main(String[] args) {
        new BeeperControl().beepForAnHour();
    }
}
