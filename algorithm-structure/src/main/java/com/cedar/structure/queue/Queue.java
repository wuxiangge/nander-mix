package com.cedar.structure.queue;

/**
 * @author zhangnan
 * @date 2020-11-15 23:58
 */
public interface Queue<E> {

    /**
     * 入队
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     *
     * @return
     */
    E dequeue();

    /**
     * 查看队首元素
     *
     * @return
     */
    E getFront();

    /**
     * 队列中元素大小
     *
     * @return
     */
    int getSize();

    /**
     * 队列是否为空
     *
     * @return
     */
    boolean isEmpty();
}
