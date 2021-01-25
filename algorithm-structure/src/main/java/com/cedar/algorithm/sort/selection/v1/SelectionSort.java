package com.cedar.algorithm.sort.selection.v1;

import java.util.Arrays;
import java.util.List;

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


    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;

            for (int j = i; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    private static void swap(int[] data, int low, int high) {
        int temp = data[low];
        data[low] = data[high];
        data[high] = temp;
    }


    public static void main(String[] args) {
        List<Double> list = Arrays.asList(0.1D, 0.1D, 0.1D, 0.1D, 0.1D);
        double sum = list.stream().mapToDouble(p -> p).sum();
        System.out.println(sum);

        List<Double> list2 = Arrays.asList(0.1D, 0.1D, 0.1D, 0.1D, 0.1D, 0.1D, 0.1D);
        double sum2 = list.stream().mapToDouble(p -> p).sum();
        System.out.println(sum2);

    }

}
