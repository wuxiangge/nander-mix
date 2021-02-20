package q04;

/**
 * @author zhangnan
 * @date 2021/2/1 13:40
 */
public class Solution {

    public double
    findMedianSortedArrays(int[] nums1, int[] nums2) {

        int nums1Length = nums1.length;

        int nums2Length = nums2.length;

        int totalLength = nums1Length + nums2Length;

        double median;
        if (totalLength % 2 == 1) {
            // 如果是奇数则取中间的数
            // 数组索引从0 开始 第k小 需要索引+1;
            int midIndex = totalLength / 2;
            median = getKthElement(nums1, nums2, midIndex + 1);
        } else {

            int midIndexL = totalLength / 2 - 1;
            int midIndexR = totalLength / 2;
            median = (getKthElement(nums1, nums2, midIndexL + 1) + getKthElement(nums1, nums2, midIndexR + 1)) * 0.5;
        }
        return median;

    }


    // 查询数组nums1和nums2中前k小的元素
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

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];

            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }

        }

    }

}
