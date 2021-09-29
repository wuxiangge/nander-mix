package q673;

/**
 * @author zhangnan
 * @date 2021/9/29
 */
public class Solution {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, maxLen = 0, ans = 0;

        // 以 nuns[i] 最长递增子序列
        int[] dp = new int[n];

        // 以 nums[i] 的最长递增子序列个数
        int[] cnt = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j]; // 重置计数
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = cnt[i]; // 重置计数
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }

    // 1 3 5 4 7
    // 1 2 3 3 4
    // 1 1 1 1 2


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
    }

}
