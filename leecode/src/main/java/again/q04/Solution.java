package again.q04;

/**
 * @author zhangnan
 * @date 2021/8/6
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int totalLength = nums1Length + nums2Length;

        double median;
        if (totalLength % 2 == 1) {
            // 合并后的数据量为奇数 去中间一位
            int mediamIndex = totalLength / 2;
            median = getKthElement(nums1, nums2, mediamIndex + 1);
        } else {
            // 合并后的数量为偶数  取中间两位的平均数
            int midIndexL = totalLength / 2 - 1;
            int midIndexR = totalLength / 2;
            median = (getKthElement(nums1, nums2, midIndexL + 1) + getKthElement(nums1, nums2, midIndexR + 1)) * 0.5;
        }
        return median;
    }


    /**
     * 从两个有序的数组中查找第K小的元素
     *
     * @param nums1 从小到大的有序数组
     * @param nums2 从小到大的有序数组
     * @param k     数组中的第K小的元素
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

}
