package q70;

import java.util.Arrays;

/**
 * @author zhangnan
 * @date 2021/2/1 19:10
 */
public class Solution {

    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
