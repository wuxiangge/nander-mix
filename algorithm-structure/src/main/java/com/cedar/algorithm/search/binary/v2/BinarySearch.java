package com.cedar.algorithm.search.binary.v2;

/**
 * 二分查找法的非递归算法
 *
 * @author zhangnan
 * @date 2021/1/19 10:39
 */
public class BinarySearch {


    private BinarySearch() {
    }


    public static <E extends Comparable<? super E>> int search(E[] array, E target) {
        int l = 0;
        int r = array.length - 1;

        // data[l...r] 中寻找target
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (array[mid].compareTo(target) == 0) {
                return mid;
            }
            if (array[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }


    // > target 的最小值索引
    public static <E extends Comparable<? super E>> int upper(E[] data, E target) {
        int l = 0;
        int r = data.length;

        while (l < r) {

            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }


    // > target ,返回最小值索引
    // == target ,返回最大索引
    public static <E extends Comparable<? super E>> int ceil(E[] data, E target) {

        int u = upper(data, target);

        if (u - 1 >= 0 && data[u - 1].compareTo(target) == 0) {
            return u - 1;
        }

        return u;
    }

}
