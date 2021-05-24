package q18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangnan
 * @date 2021/5/20 10:51
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }


    public List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        int sz = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if (sz < 2 || sz < n) {
            return res;
        }

        if (n == 2) {
            int lo = start;
            int hi = sz - 1;

            while (lo < hi) {
                int left = nums[lo];
                int right = nums[hi];
                int sum = left + right;

                if (sum < target) {
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right);
                    res.add(list);
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                }
            }
        } else {
            for (int i = start; i < sz; i++) {
                List<List<Integer>> sub = nSum(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] list = new int[]{-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();
        solution.fourSum(list, 7);
    }
}
