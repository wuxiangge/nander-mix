package com.cedar.structure.queue;

import com.cedar.structure.array.Array;

/**
 * @author zhangnan
 * @date 2020-11-17 18:52
 */
public class ArrayQueue<E> implements Queue<E> {


    private Array<E> array;


    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }


    public ArrayQueue() {
        array = new Array<>();
    }


    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        array.addFirst(e);
    }

    /**
     * 出队
     *
     * @return
     */
    @Override
    public E dequeue() {
        return array.removeLast();
    }

    /**
     * 查看队首元素
     *
     * @return
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    /**
     * 队列中元素大小
     *
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue: ");
        stringBuilder.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.get(i));
            if (i != array.getSize() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }
}
