package com.cedar.algorithm.search.linear.v1;

/**
 * 线性查找法
 * 基础版本
 *
 * @author zhangnan
 * @date 2020-11-15 14:28
 */
public class LinearSearch {

    private LinearSearch() {
    }

    public static int search(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static <E> int search2(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {12, 34, 56, 78, 77, 44};
        int result = LinearSearch.search(data, 33);
        System.out.println(result);
    }



}
