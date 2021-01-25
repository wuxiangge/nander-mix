package com.cedar.concurrency.art;

/**
 * @author zhangnan
 * @date 2021/1/22 17:13
 */
public interface ThreadPool<Job extends Runnable> {


    void execute(Job job);

    void shutdown();

    void addWorkers(int num);

    void removeWorker(int num);

    int getJobSize();



}
