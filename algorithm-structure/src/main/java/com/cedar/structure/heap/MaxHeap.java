package com.cedar.structure.heap;

import com.cedar.structure.array.Array;

/**
 * @author zhangnan
 * @date 2021/1/25 19:07
 */
public class MaxHeap<E extends Comparable<E>> {


    private Array<E> data;

    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }


    public MaxHeap() {
    }


}
