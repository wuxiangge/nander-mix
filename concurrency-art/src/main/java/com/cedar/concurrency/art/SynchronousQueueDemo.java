package com.cedar.concurrency.art;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {


    public static void main(String[] args) throws Exception {

        SynchronousQueue<String> queue = new SynchronousQueue<String>();

        new Thread(() -> {
            try {
                queue.put("张楠");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(10);

        String take = queue.take();
        System.out.println(take);


    }
}
