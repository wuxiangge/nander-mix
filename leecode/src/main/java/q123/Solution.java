package q123;

/**
 * @author zhangnan
 * @date 2021-05-17 22:18
 * @description
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        dp[0][0][0] = 0;
        for (int k = 1;k<=max_k;k++) {
            dp[0][k][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= max_k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxProfit(new int[]{1,2,3,4,5});
    }
}
