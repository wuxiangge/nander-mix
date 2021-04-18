package com.cedar.structure.heap;

import com.cedar.structure.array.Array;

/**
 * 最大堆
 *
 * @author zhangnan
 * @date 2021/1/25 19:07
 */
public class MaxHeap<E extends Comparable<? super E>> {


    private Array<E> data;

    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }


    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }


    public boolean isEmpty() {
        return data.isEmpty();
    }


    public int size() {
        return data.getSize();
    }


    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }

        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }


    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty!");
        }

        return data.getFirst();
    }

    public E extractMax() {
        E t = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return t;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {

            int j = leftChild(k);

            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            // data[j] 是 leftChild rightChild 中的最大值
            if (data.get(k).compareTo(data.get(j)) > 0) {
                break;
            }

            data.swap(k, j);
            k = j;

        }
    }


    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


}
