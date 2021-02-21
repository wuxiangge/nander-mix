package com.cedar.algorithm.sort;

/**
 * @author zhangnan
 * @date 2021/2/21 16:18
 */
public class Sorts {

    private Sorts() {
    }

    // 排序模板
    public static <E extends Comparable<? super E>> void sort(E[] arr) {

    }

    // 插入排序算法
    public static <E extends Comparable<? super E>> void insertSort(E[] arr) {
        // 循环不变量 [0...i) 已经排好序 现在准备将 i 放到[0...i)中的合适位置

        int length = arr.length;

        for (int i = 1; i < length; i++) {

            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    // 插入排序算法优化
    public static <E extends Comparable<? super E>> void insertSortUpdate(E[] arr) {

        int length = arr.length;
        // 循环不变量 [0...i) 已经排好序 现在准备将 i 放到[0...i)中的合适位置
        for (int i = 0; i < length; i++) {

            E ret = arr[i];

            int j; // i应该插入的正确位置

            for (j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }

            arr[j] = ret;

            ret = null; //help gc
        }
    }


    // 选择排序算法
    public static <E extends Comparable<? super E>> void selectSort(E[] arr) {
        // 循环不变量 [0...i) 已经排好序 现在从[i....arr.length) 中选择最小值 放入 arr[i]

        int length = arr.length;

        for (int i = 0; i < length; i++) {

            int min = i;  // 记录[i....arr.length) 最小值的索引

            for (int j = i; j < length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }

            swap(arr, i, min);
        }
    }


    // 希尔排序算法
    public static <E extends Comparable<? super E>> void shellSort(E[] arr) {

        // 算法基本思想 对等距数组排序
        int length = arr.length;

        int h = 1; // 等距数组的距离
        while (h < length) {
            h = 3 * h + 1;
        }


        while (h >= 1) {

            // 对data[start,start+h,start+2h... ] 进行插入排序

            for (int i = h; i < length; i += h) {

                E ret = arr[i];

                int j; // i应该插入的正确位置

                for (j = i; j - h >= 0 && arr[j].compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }

                arr[j] = ret;

                ret = null; //help gc

            }
            h = h / 3;
        }
    }


    // 冒泡排序算法 todo...
    public static <E extends Comparable<? super E>> void bubbleSort(E[] arr) {
        int length = arr.length;

        for (int i = 0; i < length; i++) {

            // arr[n-i...n) 已经排好序了
            // 通过冒泡在arr[n-i-1] 放上合适的数据


            for (int j = 0; j < length - i - 1; j++) {


            }


        }
    }


    private static <E> void swap(E[] arr, int l, int h) {
        E temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
        temp = null;   //help gc
    }
}
