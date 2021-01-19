package com.cedar.algorithm.search.binary.v1;

/**
 * 递归查找数据
 *
 * @author zhangnan
 * @date 2021/1/19 10:39
 */
public class BinarySearch {


    private BinarySearch() {
    }


    public static <E extends Comparable<? super E>> int search(E[] array, E target) {
        return search(array, 0, array.length - 1, target);
    }


    private static <E extends Comparable<? super E>> int search(E[] array, int l, int r, E target) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;

        if (array[mid].compareTo(target) == 0) {
            return mid;
        }

        if (array[mid].compareTo(target) < 0) {
            return search(array, mid + 1, r, target);
        }

        return search(array, l, mid - 1, target);
    }


}
