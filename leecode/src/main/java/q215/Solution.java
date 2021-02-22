package q215;

import java.util.Random;

/**
 * @author zhangnan
 * @date 2021/2/22 14:25
 */
//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 示例 1:
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
// 说明:
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
// Related Topics 堆 分治算法
// 👍 896 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;

        int target = nums.length - k;

        Random random = new Random();

        while (l < r) {
            int mid = quickSort(nums, l, r, random);
            if (mid == target) {
                return nums[mid];
            }
            if (mid < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l];
    }


    // 快速排序算法
    private int quickSort(int[] nums, int l, int r, Random random) {

        int p = partition(nums, l, r, random);

        return p;
    }


    private int partition(int[] nums, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        swap(nums, l, p);

        int i = l + 1;
        int j = r;

        // arr[l+1...i-1]<=v;arr[j+1...r]>=v

        while (true) {

            while (i <= j && nums[i] < (nums[l])) {
                ++i;
            }

            while (j >= i && nums[j] > (nums[l])) {
                --j;
            }

            if (i >= j) {
                break;
            }

            swap(nums, i, j);
            i++;
            j--;

        }

        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

