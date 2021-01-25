package com.cedar.algorithm.sort.selection.v2;

/**
 * @author zhangnan
 * @date 2020-11-15 15:29
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
    public static <E extends Comparable<? super E>> void sort(E[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i; j < data.length; j++) {
                if (data[minIndex].compareTo(data[j]) > 0) {
                    minIndex = j;
                }
            }
            swap(data, i, minIndex);
        }
    }


    public static <E extends Comparable<? super E>> void selectSort(E[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;

            for (int j = i; j < array.length; j++) {
                if (array[min].compareTo(array[j]) > 0) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    private static <E> void swap(E[] data, int low, int high) {
        E temp = data[low];
        data[low] = data[high];
        data[high] = temp;
        temp = null;
    }

}
