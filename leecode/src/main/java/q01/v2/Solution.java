package q01.v2;

import java.util.Arrays;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum < target) {
                low++;
            } else if (sum > target) {
                high--;
            } else if (sum == target) {
                return new int[]{low, high};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {

    }
}
