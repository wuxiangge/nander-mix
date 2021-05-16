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
            } else if (array[mid].compareTo(target) > 0) {
                r = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 0123456789         5
     * @param nums
     * @param target
     * @return
     */
    public int left_bound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
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
