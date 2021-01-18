package com.cedar.algorithm.sort.quick.v3;

import java.util.Random;

/**
 * 三路快速排序
 */
public class QuickSortT {

    public static <E extends Comparable<? super E>> void sort(E[] arr) {
        Random rnd = new Random();
        sort(arr, 0, arr.length - 1, rnd);
    }

    private static <E extends Comparable<? super E>> void sort(E[] arr, int l, int r, Random rnd) {
        if (l >= r) {
            return;
        }

        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l+1...lt]<v arr[lt+1...i-1]===v arr[gt...r]>v
        int lt = l;
        int i = l + 1;
        int gt = r + 1;
        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, i, gt);
            } else {
                // arr[i] == arr[l]
                i++;
            }
        }

        swap(arr, l, lt);
        // arr[l+1...lt-1]<v arr[lt...gt-1]===v arr[gt...r]>v

        sort(arr, l, lt - 1, rnd);
        sort(arr, gt, r, rnd);
    }


    private static <E> void swap(E[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        temp = null;
    }

}
