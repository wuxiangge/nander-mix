package com.cedar.algorithm.sort.quick.v1;

import java.util.Random;

public class QuickSort {

    private QuickSort() {
    }

    public static <E extends Comparable<? super E>> void sort(E[] arr) {
        quickSort(arr, 0, arr.length - 1);

    }

    private static <E extends Comparable<? super E>> void quickSort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private static <E extends Comparable<? super E>> int partition(E[] arr, int l, int r) {
        // 生成[l...r]之间的随机值

        int p = l + (new Random()).nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l+1...j] < v  arr[j+1...i] >v
        int j = l;
        for (int i = l + 1; i < r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }


    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        temp = null;
    }


}
