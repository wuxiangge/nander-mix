//package com.cedar.structure.heap;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @author zhangnan
// * @date 2021/1/28 16:18
// */
//public class MinHeap<E extends Comparable<? super E>> {
//
//    //用来存放数据
//    private List<E> arrayList;
//
//    public MinHeap() {
//        this.arrayList = new ArrayList<>();
//    }
//
//    public MinHeap(E[] data) {
//        heapify(data);
//    }
//
//    private void heapify(E[] data) {
//        arrayList = new ArrayList<>();
//        arrayList.addAll(Arrays.asList(data));
//        for (int i = parent(data.length - 1); i >= 0; i--)
//            siftDown(i, arrayList);
//    }
//
//    private int parent(int k) {
//        if (k == 0) throw new IllegalArgumentException();
//        return (k - 1) / 2;
//    }
//
//    private int leftChild(int k) {
//        return 2 * k + 1;
//    }
//
//
//    private void siftDown(int index, List<E> data) {
//        while (leftChild(index) < data.size()) {
//            int j = leftChild(index); // 定义子树中较小的那一个
//            if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) < 0) {
//                j = j + 1;
//            }
//            if (data.get(index).compareTo(data.get(j)) < 0) {
//                break;
//            }
//            swap(data, index, j);
//            index = j;
//        }
//    }
//
//    private void siftUp(int k, List<E> data) {
//        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) > 0) {
//            swap(data, parent(k), k);
//            k = parent(k);
//        }
//    }
//
//    private void swap(List<E> data, int l, int r) {
//        E temp = data.get(l);
//        data.set(l, data.get(r));
//        data.set(r, temp);
//        temp = null;
//    }
//}
