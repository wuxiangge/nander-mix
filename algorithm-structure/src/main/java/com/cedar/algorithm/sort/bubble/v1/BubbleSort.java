package com.cedar.algorithm.sort.bubble.v1;

/**
 * @author zhangnan
 * @date 2021/1/28 17:33
 */
public class BubbleSort {

    private BubbleSort() {
    }

    public static <E extends Comparable<? super E>> void sort(E[] data) {
        for (int i = 0; i + 1 < data.length; i++) {
            // arr[n-i...n) 已经排好序了
            // 通过冒泡在arr[n-i-1] 放上合适的数据
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                }
            }
        }
    }


    private static <E> void swap(E[] data, int l, int r) {
        E ret = data[l];
        data[l] = data[r];
        data[r] = ret;
    }
}
