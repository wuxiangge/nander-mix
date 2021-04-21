package com.cedar.algorithm.sort.radix;

/**
 * 基数排序
 * 桶排序
 * <p>
 * 经典空间换时间
 *
 * @author zhangnan
 * @date 2021/2/23 9:55
 */
public class RadixSort {

    public static void radixSort(int[] data) {
        int[][] buckets = new int[10][data.length];
        int[] bucketElementCounts = new int[10];

        int maxNum = data[0];
        for (int num : data) {
            if (num > maxNum) {
                maxNum = num;
            }
        }

        // 这一组数据中最大数的长度
        int length = String.valueOf(maxNum).length();

        int digitOfElement;
        int index;

        for (int i = 0, j = 1; i < length; i++, j *= 10) {
            // 将数组arr中的元素，根据指定的位数。放入对应的桶中
            for (int element : data) {
                // 计算桶号
                digitOfElement = element / j % 10;
                buckets[digitOfElement][bucketElementCounts[digitOfElement]++] = element;
            }

            // 遍历每个桶，将元素放入原数组arr中
            index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    data[index++] = buckets[k][l];
                }
                bucketElementCounts[k] = 0;
            }
        }
    }
}
