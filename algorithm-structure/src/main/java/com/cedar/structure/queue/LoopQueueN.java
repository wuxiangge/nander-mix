package com.cedar.structure.queue;

/**
 * 不浪费一个空间
 *
 * @param <E>
 */
public class LoopQueueN<E> implements Queue<E> {

    private E[] data;

    private int front, tail;

    private int size;

    public LoopQueueN(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }


    public int getCapacity() {
        return data.length;
    }

    public LoopQueueN() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {

        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty qu= eue.");
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

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty qu= eue.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
}
