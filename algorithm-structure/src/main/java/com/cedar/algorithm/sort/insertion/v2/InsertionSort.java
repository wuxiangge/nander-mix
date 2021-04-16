package com.cedar.algorithm.sort.insertion.v2;

/**
 * @author zhangnan
 * @date 2020-11-15 16:19
 */
public class InsertionSort {

    private InsertionSort() {
    }

    /**
     * array[0...i] 已经排序
     *
     * @param array
     */
    public static <E extends Comparable<? super E>> void sort(E[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 1 && array[j].compareTo(array[j - 1]) < 0; j--) {
                swap(array, j, j - 1);
            }
        }
    }


    public static <E extends Comparable<? super E>> void sortUpdate(E[] array, int l, int r) {
        for (int i = l; i <= r; i++) {
            for (int j = i; j - 1 >= l && array[j].compareTo(array[j - 1]) < 0; j--) {
                swap(array, j, j - 1);
            }
        }
    }


    public static <E extends Comparable<? super E>> void insertSort(E[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j - 1 >= 0 && array[j].compareTo(array[j - 1]) < 0; j--) {
                swap(array, j - 1, j);
            }
        }
    }


    public static <E extends Comparable<? super E>> void updateInsertSort(E[] array) {
        for (int i = 0; i < array.length; i++) {
            // 待插入的数据
            E ret = array[i];

            // 应该插入的位置
            int j;

            for (j = i; j - 1 >= 0 && ret.compareTo(array[j]) < 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = ret;
            ret = null;
        }
    }


    /**
     * 插入排序算法优化
     * array[0...i] 已经排序
     *
     * @param array
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void sort2(E[] array) {
        for (int i = 0; i < array.length; i++) {
            // 待插入的数据
            E t = array[i];
            // 应该插入的位置
            int j;
            for (j = i; j >= 1 && t.compareTo(array[j - 1]) < 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = t;
            // help gc
            t = null;
        }
    }


    /**
     * 插入排序算法优化
     * 提供归并排序算法使用的可能
     *
     * @param array
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void sort(E[] array, int l, int r) {
        for (int i = l; i <= r; i++) {
            // 待插入的数据
            E t = array[i];
            // 应该插入的位置
            int j;
            for (j = i; j - 1 >= l && t.compareTo(array[j - 1]) < 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = t;
            // help gc
            t = null;
        }
    }

    private static <E extends Comparable<? super E>> void swap(E[] data, int low, int high) {
        E temp = data[low];
        data[low] = data[high];
        data[high] = temp;
        // help gc
        temp = null;
    }
}
