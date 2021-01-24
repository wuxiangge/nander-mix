package com.cedar.algorithm.sort.merge.v5;

import java.util.Arrays;

/**
 * 归并排序算法
 */
public class MergeSort {

    private MergeSort() {
    }

    /**
     * 自底向上
     *
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void mergeSortDownToUp(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);

        int n = arr.length;

        // 遍历合并区间的长度
        for (int size = 1; size < n; size += size) {
            // 遍历合并的两个区间的起始位置 i
            // 合并[i,i+size-1] 和 [i+size,i+size+size-1]
            for (int i = 0; i + size < n; i += size + size) {
                if (arr[i + size - 1].compareTo(arr[i + size]) > 0) {
                    merge(arr, i, i + size - 1, Math.min(i + size + size - 1, n - 1), temp);
                }
            }
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
