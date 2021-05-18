package q188;

/**
 * @author zhangnan
 * @date 2021-05-17 23:52
 * @description
 */
public class Solution {


    public int maxProfit(int k, int[] prices) {

        if (prices.length == 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return maxProfit(prices);
        }
        int[][][] dp = new int[prices.length][k + 1][2];
        dp[0][0][0] = 0;
        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = k; j > 0; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }

    public int maxProfit(int[] prices) {
        int profit0 = 0, profit1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit0 = Math.max(profit0, profit1 + prices[i]);
            profit1 = Math.max(profit1, profit0 - prices[i]);
        }
        return profit0;
    }

}
