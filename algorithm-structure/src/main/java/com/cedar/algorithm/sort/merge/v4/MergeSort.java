package com.cedar.algorithm.sort.merge.v4;

import com.cedar.algorithm.sort.insertion.v2.InsertionSort;

import java.util.Arrays;

/**
 * 归并排序算法
 * 优化思路 内存优化
 */
public class MergeSort {

    private MergeSort() {
    }

    /**
     * 自顶向下
     *
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void mergeSortUpToDown(E[] arr) {

        E[] temp = Arrays.copyOf(arr, arr.length);
        mergeSortUpToDown(arr, 0, arr.length - 1, temp);
    }

    /**
     * 自顶向下归并排序
     *
     * @param arr
     * @param l
     * @param r
     * @param <E>
     */
    private static <E extends Comparable<? super E>> void mergeSortUpToDown(E[] arr, int l, int r, E[] temp) {

        // 使用插入排序算法优化
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = l + (r - l) / 2;

        mergeSortUpToDown(arr, l, mid, temp);

        mergeSortUpToDown(arr, mid + 1, r, temp);

        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, temp);
        }

    }

    /**
     * 合并两个有序区间 arr[l mid] arr[mid+1,r]
     *
     * @param arr
     * @param l
     * @param r
     * @param <E>
     */
    private static <E extends Comparable<? super E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {

        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

}
