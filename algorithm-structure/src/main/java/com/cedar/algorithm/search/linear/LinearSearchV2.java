package com.cedar.algorithm.search.linear;

/**
 * 使用泛型
 * 泛型中只能使用类对象
 *
 * @author zhangnan
 * @date 2020-11-15 14:36
 */
public class LinearSearchV2<E> {

    private LinearSearchV2() {
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
        int result = LinearSearchV2.<Integer>search(data, 33);
        System.out.println(result);
    }

}
