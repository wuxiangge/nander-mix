package again.q04;

/**
 * @author zhangnan
 * @date 2021/8/6
 */
public class Solution {


    //给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
    //
    //
    //
    // 示例 1：
    //
    //
    //输入：nums1 = [1,3], nums2 = [2]
    //输出：2.00000
    //解释：合并数组 = [1,2,3] ，中位数 2
    //
    //
    // 示例 2：
    //
    //
    //输入：nums1 = [1,2], nums2 = [3,4]
    //输出：2.50000
    //解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
    //
    //
    // 示例 3：
    //
    //
    //输入：nums1 = [0,0], nums2 = [0,0]
    //输出：0.00000
    //
    //
    // 示例 4：
    //
    //
    //输入：nums1 = [], nums2 = [1]
    //输出：1.00000
    //
    //
    // 示例 5：
    //
    //
    //输入：nums1 = [2], nums2 = []
    //输出：2.00000
    //
    //
    //
    //
    // 提示：
    //
    //
    // nums1.length == m
    // nums2.length == n
    // 0 <= m <= 1000
    // 0 <= n <= 1000
    // 1 <= m + n <= 2000
    // -106 <= nums1[i], nums2[i] <= 106
    // 012
    //
    //
    //
    // 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
    // Related Topics 数组 二分查找 分治
    // 👍 4547 👎 0

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int totalLength = nums1Length + nums2Length;

        double median;
        if (totalLength % 2 == 1) {
            // 合并后的数据量为奇数 去中间一位
            int medianIndex = totalLength / 2;
            median = getKthElement(nums1, nums2, medianIndex + 1);
        } else {
            // 合并后的数量为偶数  取中间两位的平均数
            int midIndexL = totalLength / 2 - 1;
            int midIndexR = totalLength / 2;
            median = (getKthElement(nums1, nums2, midIndexL + 1) + getKthElement(nums1, nums2, midIndexR + 1)) * 0.5;
        }
        return median;
    }

    // 12        2
    // 34        2
    // 1234      4
    // midIndexL = 4/2-1
    // midIndexR = 4/2


    /**
     * 从两个有序的数组中查找第K小的元素
     *
     * @param nums1 从小到大的有序数组
     * @param nums2 从小到大的有序数组
     * @param k     数组中的第K小的元素 从1开始
     * @return
     */
    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int index1 = 0;
        int index2 = 0;


        while (true) {
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }

            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            if (k == length1 + length2) {
                return Math.max(nums1[length1 - 1], nums2[length2 - 1]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];

            if (pivot1 <= pivot2) {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }


    // 简单解决方案 合并两个有序数组


}
