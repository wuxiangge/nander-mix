package labuladong.q322;

import java.util.Arrays;

/**
 * @author zhangnan
 * @className Solution
 * @date 2021/8/16
 * @description //TODO
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == Integer.MIN_VALUE ? -1 : dp[amount];
    }


}
