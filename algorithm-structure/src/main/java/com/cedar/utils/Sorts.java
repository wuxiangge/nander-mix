package com.cedar.utils;

import java.util.Random;

/**
 * @author zhangnan
 * @date 2021/8/3
 */
public class Sorts {

    private Sorts() {
    }

    // 基础模板
    public static <E extends Comparable<E>> void sort(E[] array) {
    }


    // 冒泡排序
    public static <E extends Comparable<E>> void bubbleSort(E[] array) {
        // 排序基本思想
        // [1,2,3,4,.....,n]
        // 对于冒泡排序来说
        // [1,2,3,...,array.length-1-i] 还没有排好序
        // 但是对于 (array.length-1-i,...,array.length-1] 已经排好序
        for (int i = 0; i < array.length - 1; i++) {
            // 在【array.length-1-i】的位置上放上合适的参数
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }


    public static <E extends Comparable<E>> void bubbleSort2(E[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    isSwapped = true;
                    swap(array, j, j + 1);
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }


    public static <E extends Comparable<E>> void bubbleSort3(E[] array) {
        for (int i = 0; i < array.length - 1; ) {
            int isSwappedIndex = 0;

            // [1,2,3,4,5,6,7,0]
            // [1,2,3,4,5,6,0,7]
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    isSwappedIndex = j + 1;
                    swap(array, j, j + 1);
                }
            }
            i = array.length - isSwappedIndex;
        }
    }


    // 插入排序算法
    public static <E extends Comparable<E>> void insertSort(E[] array) {
        //插入排序算法基本思想
        // [1,2,3,...,i) 已经排好序了
        // 现在需要将array[i]插入到合适的位置

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j - 1 > 0 && array[j].compareTo(array[j - 1]) < 0; j--) {
                swap(array, j, j - 1);
            }
        }
    }

    // 优化版本插入算法
    public static <E extends Comparable<E>> void insertSort2(E[] array) {
        for (int i = 0; i < array.length; i++) {
            E temp = array[i];  // 带插入的元素

            int j; // 应该插入的位置

            for (j = i; j - 1 > 0 && temp.compareTo(array[j]) < 0; j--) {
                array[j] = array[j - 1];
            }

            array[j] = temp;
            temp = null;
        }
    }


    // 希尔排序
    public static <E extends Comparable<E>> void shellSort(E[] array) {
        // 等距数组排序
        int h = 1;
        while (h < array.length) {
            h = 3 * h + 1;
        }

        // 希尔排序基本思想  等距数组排序
        // 对data[start,start+h,start+2h... ] 进行插入排序
        while (h >= 1) {
            // 对data[start,start+h,start+2h... ] 进行插入排序

            for (int i = h; i < array.length; i++) {
                E ret = array[i];
                int j;
                for (j = i; j - h > 0 && ret.compareTo(array[j - h]) < 0; j -= h) {
                    array[j] = array[j - h];
                }
                array[j] = ret;
            }
            h = h / 3;
        }
    }


    // 快速排序
    public static <E extends Comparable<E>> void quickSort1(E[] array) {
        // 快速排序基本思想 是一种划分交换排序 采用分治策略
        Random random = new Random();
        quickSort1(array, 0, array.length - 1, random);
    }

    private static <E extends Comparable<E>> void quickSort1(E[] array, int l, int r, Random random) {
        if (l >= r) {
            return;
        }

        int p = partition(array, l, r, random);
        quickSort1(array, 0, p - 1, random);
        quickSort1(array, p + 1, r, random);
    }

    /**
     * [1,2,3,4,5,6,]   random = 4
     * [4,1,2,3,,5,6]
     * <p>
     * for (int i = l+1;i<=r;i++) {
     * if (array[i].compareTo(array[l])<0) {
     * j++;
     * swap(array,i,j);
     * }
     * }
     *
     * @param array
     * @param l
     * @param r
     * @param random
     * @param <E>
     * @return
     */
    private static <E extends Comparable<E>> int partition(E[] array, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);   // [l,,,r] 中间生成一个随机值
        swap(array, l, p);
        // data[l+1...j] < v  data[j+1...i] >v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (array[i].compareTo(array[l]) < 0) {
                j++;
                swap(array, i, j);
            }
        }
        swap(array, l, j);
        return j;
    }


    private static <E> void swap(E[] array, int l, int r) {
        E temp = array[l];
        array[l] = array[r];
        array[r] = temp;
        temp = null;
    }

}
