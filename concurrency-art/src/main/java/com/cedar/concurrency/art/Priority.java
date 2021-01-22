package com.cedar.concurrency.art;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangnan
 * @date 2021/1/21 17:17
 */
public class Priority {


    private static volatile boolean notStart = true;

    private static volatile boolean notEnd = true;


    public static void main(String[] args) throws InterruptedException {
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;

            Job job = new Job(priority);

            jobs.add(job);

            Thread thread = new Thread(job, "Thread" + i);

            thread.setPriority(priority);
            thread.start();
        }


        notStart = false;

        TimeUnit.SECONDS.sleep(10);

        notEnd = false;

        for (Job job : jobs) {
            System.out.println("Job Priority: " + job.priority + ", count:" + job.jobCount);
        }
    }


    static class Job implements Runnable {

        private int priority;

        private int jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart) {
                Thread.yield();
            }
            while (notEnd) {
                Thread.yield();
                jobCount++;
            }
        }
    }
}
