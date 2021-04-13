package com.cedar.concurrency.art;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {


    public static void main(String[] args) throws Exception {

        new BufferedReader(new InputStreamReader(System.in));

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
