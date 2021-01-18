package com.cedar.algorithm.sort.quick.v2;

import java.util.Random;

/**
 * 双路快速排序
 */
public class QuickSortD {

    public static <E extends Comparable<? super E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<? super E>> void sort(E[] arr, int l, int r, Random random) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r, random);
        sort(arr, l, p - 1, random);
        sort(arr, p + 1, l, random);
    }

    // 双路快速排序
    private static <E extends Comparable<? super E>> int partition(E[] arr, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l+1...i-1]<=v;arr[j+1...r]>=v
        int i = l + 1;
        int j = r;

        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }
            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
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
