package q416;

import java.util.Arrays;

/**
 * @author zhangnan
 * @date 2021/5/20 16:48
 */
public class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 背包容量充足 放入或者不放入
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

}
