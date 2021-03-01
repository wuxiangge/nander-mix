package q198;

import java.util.Arrays;

/**
 * @author zhangnan
 * @date 2021/3/1 9:50
 */
public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            // dp[i] 和 nums[i-1] 存在偏差
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }

        return dp[n];
    }

}
