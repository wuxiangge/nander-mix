package com.cedar.algorithm.search.linear.v2;

/**
 * 使用泛型
 * 泛型中只能使用类对象
 *
 * @author zhangnan
 * @date 2020-11-15 14:36
 */
public class LinearSearch {

    private LinearSearch() {
    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            // 类型对象相等使用equals
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] data = {12, 34, 56, 78, 77, 44};
        int result = LinearSearch.search(data, 33);
        System.out.println(result);
    }

}
