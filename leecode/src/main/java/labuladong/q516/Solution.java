package labuladong.q516;

/**
 * @author zhangnan
 * @date 2021/10/19
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        if (n < 2) {
            return n;
        }

        // 定义dp[i][j]是s[i...j]最长子序列
        int[][] dp = new int[n][n];

        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // 反着遍历保证正确的状态转移方程
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i + 1; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[0][n - 1];
    }
}
