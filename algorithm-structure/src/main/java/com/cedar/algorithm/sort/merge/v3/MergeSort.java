package com.cedar.algorithm.sort.merge.v3;

import com.cedar.algorithm.sort.insertion.v2.InsertionSort;

import java.util.Arrays;

/**
 * 归并排序算法
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
        mergeSortUpToDown(arr, 0, arr.length - 1);
    }

    /**
     * 自顶向下归并排序
     *
     * @param arr
     * @param l
     * @param r
     * @param <E>
     */
    private static <E extends Comparable<? super E>> void mergeSortUpToDown(E[] arr, int l, int r) {

        // 使用插入排序算法优化
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = l + (r - l) / 2;

        mergeSortUpToDown(arr, l, mid);

        mergeSortUpToDown(arr, mid + 1, r);

        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
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
    private static <E extends Comparable<? super E>> void merge(E[] arr, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

}
