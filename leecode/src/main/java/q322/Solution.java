package q322;

import java.util.Arrays;

/**
 * 动态规划
 * 动态转移方程
 * 递归树
 * base case
 * 状态
 *
 * @author zhangnan
 * @date 2021/5/8 10:56
 */


//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
// 你可以认为每种硬币的数量是无限的。
//
//
//
// 示例 1：
//
//
//输入：coins = [1, 2, 5], amount = 11
//输出：3
//解释：11 = 5 + 5 + 1
//
// 示例 2：
//
//
//输入：coins = [2], amount = 3
//输出：-1
//
// 示例 3：
//
//
//输入：coins = [1], amount = 0
//输出：0
//
//
// 示例 4：
//
//
//输入：coins = [1], amount = 1
//输出：1
//
//
// 示例 5：
//
//
//输入：coins = [1], amount = 2
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
//
// Related Topics 动态规划
// 👍 1254 👎 0

public class Solution {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;

        // 定义dp[i]的含义为 总金额为i时 需要的兑换的最小次数
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int minFallingPathSum(int[][] matrix) {
        int length = matrix.length;

        // 定义dp数组:dp[i][j]的下降路径
        int[][] dp = new int[length + 1][length + 1];

        // base case
        for (int i = 0; i < length; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int up_left = Integer.MAX_VALUE;
                int up = dp[i - 1][j];
                int up_right = Integer.MAX_VALUE;

                if (j - 1 >= 0) {
                    up_left = dp[i - 1][j - 1];
                }

                if (j + 1 < length) {
                    up_right = dp[i - 1][j + 1];
                }
                dp[i][j] = Math.min(up, Math.min(up_left, up_right)) + matrix[i][j];
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            res = Math.min(res, dp[length - 1][i]);
        }
        return res;
    }

}
