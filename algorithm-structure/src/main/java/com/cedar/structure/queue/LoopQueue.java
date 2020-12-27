package com.cedar.structure.queue;

/**
 * 循环队列
 * front  == tail 队列为空
 * tail + 1 == front 队列满
 * <p>
 * <p>
 * (tail + 1) % c  = front 队列为满
 * 浪费一个空间 用来记录队列的大小
 *
 * @author zhangnan
 * @date 2020-11-17 20:17
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front, tail;

    /**
     * 可以使用 front 和 tail 字段完成 tail 计算
     */
    private int size;


    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }


    public int getCapacity() {
        return data.length - 1;
    }


    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 出队
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列已经为空");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    /**
     * 查看队首元素
     *
     * @return
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列已经为空");
        }
        return data[front];
    }

    /**
     * 队列中元素大小
     *
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        stringBuilder.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            stringBuilder.append(data[i]);
            if ((i + 1) % data.length != tail) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }
}
