package com.cedar.algorithm.sort.selection;

/**
 * 选择排序算法
 * 原地排序
 *
 * @author zhangnan
 * @date 2020-11-15 15:08
 */
public class SelectionSort {

    private SelectionSort() {
    }

    /**
     * 循环不变量
     * data[i...n) 中最小值
     *
     * @param data
     */
    public static void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i; j < data.length; j++) {
                if (data[minIndex] > data[j]) {
                    minIndex = j;
                }
            }
            swap(data, i, minIndex);
        }
    }

    private static void swap(int[] data, int low, int high) {
        int temp = data[low];
        data[low] = data[high];
        data[high] = temp;
    }

}
