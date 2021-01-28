package com.cedar.algorithm.sort.heap;

import com.cedar.structure.heap.MaxHeap;

/**
 * @author zhangnan
 * @date 2021/1/28 16:47
 */
public class HeapSort {


    private HeapSort() {
    }

    public static <E extends Comparable<? super E>> void sort(E[] data) {
        MaxHeap<E> maxHeap = new MaxHeap<>();

        for (E e : data) {
            maxHeap.add(e);
        }

        for (int i = data.length; i >= 0; i--) {
            data[i] = maxHeap.extractMax();
        }
    }
}
