package com.cedar.structure.heap;

import java.util.ArrayList;

/**
 * @author zhangnan
 * @date 2021/1/28 16:18
 */
public class MinHeap<E extends Comparable<? super E>> {


    //  用来存放数据
    private ArrayList<E> arrayList;


    public MinHeap() {
        this.arrayList = new ArrayList<>();
    }

    public MinHeap(E[] data) {
        heapify(data);
    }


    private void heapify(E[] data) {
        for (int i = parent(data.length - 1); i >= 0; i--)
            siftDown(i, data);
    }


    private int parent(int k) {
        if (k == 0) throw new IllegalArgumentException();
        return (k - 1) / 2;
    }

    private int leftChild(int k) {
        return 2 * k + 1;
    }

    private int rightChild(int k) {
        return 2 * k + 2;
    }


    private void siftDown(int index, E[] data) {
        while (leftChild(index) < data.length) {

            int j = leftChild(index); // 定义子树中较小的那一个

            if (j + 1 < data.length && data[j + 1].compareTo(data[j]) < 0) {
                j = j + 1;
            }

            if (data[index].compareTo(data[j]) < 0) {
                break;
            }

            swap(data, index, j);
            index = j;
        }
    }


    private void swap(E[] data, int l, int r) {
        E temp = data[l];
        data[l] = data[r];
        data[r] = temp;
        temp = null;
    }
}
