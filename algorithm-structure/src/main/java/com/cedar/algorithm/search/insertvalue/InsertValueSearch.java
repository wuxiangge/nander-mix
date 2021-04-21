package com.cedar.algorithm.search.insertvalue;

/**
 * 插值搜索法
 *
 * @author zhangnan
 * @date 2021/4/21 14:42
 */
public class InsertValueSearch {

    private InsertValueSearch() {

    }

    public static <E extends Comparable<? super E>> int insertValueSearch(int[] array, int target) {
        return insertValueSearch(array, 0, array.length - 1, target);
    }


    private static <E extends Comparable<E>> int insertValueSearch(int[] arr, int left, int right, int target) {

        //注意：findVal < arr[0]  和  findVal > arr[arr.length - 1] 必须需要
        //否则我们得到的 mid 可能越界
        if (left > right || target < arr[0] || target > arr[arr.length - 1]) {
            return -1;
        }

        // 求出mid, 自适应
        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (target > midVal) { // 说明应该向右边递归
            return insertValueSearch(arr, mid + 1, right, target);
        } else if (target < midVal) { // 说明向左递归查找
            return insertValueSearch(arr, left, mid - 1, target);
        } else {
            return mid;
        }
    }
}
