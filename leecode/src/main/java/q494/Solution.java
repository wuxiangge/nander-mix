package q494;

import java.util.Arrays;

/**
 * @author zhangnan
 * @date 2021/10/21
 */
public class Solution {


    public int findTargetSumWays(int[] nums, int target) {
        // sum(A) - sum(B) = target
        // sum(A) == target + sum(B)
        // 2*sum(A) = sum(A+B) + target
        // sum(A) == (sum(A+B) + target)/2

        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (n == 0 || sum + target < 0 || (sum + target) % 2 == 1) {
            return 0;
        }

        return helper(nums, (target + sum) / 2);
    }


    /**
     * 寻找 数组中指定元素的和为target的数量
     *
     * @param nums
     * @param target
     * @return
     */
    int helper(int[] nums, int target) {
        int n = nums.length;

        // dp[i][j] 对于数组中前i个元素 目标和为j的最大组装次数
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    // 装入背包和不装入背包
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    // 不选择装入
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }
}
