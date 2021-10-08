package q53;

/**
 * @author zhangnan
 * @date 2021/10/8
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        // 以nums[i]为结尾的「最大子数组和」为dp[i]

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
