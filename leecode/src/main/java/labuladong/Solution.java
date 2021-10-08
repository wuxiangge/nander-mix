package labuladong;

/**
 * @author zhangnan
 * @date 2021/10/8
 */
public class Solution {


    //    给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。其中第i个物品的重量为wt[i]，价值为val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
    //    举个简单的例子，输入如下：
    //    N = 3, W = 4
    //    wt = [2, 1, 3]
    //    val = [4, 2, 3]


    /**
     * 0-1 背包问题
     *
     * @param W   背包可装重量为W
     * @param N   背包可装物品为N
     * @param wt  每个物品的重量
     * @param val 每个物品的价值
     * @return 求装入的最大的价值
     */
    public int knapsack(int W, int N, int[] wt, int[] val) {

        // dp[i][w]的定义如下：对于前i个物品，当前背包的容量为w，这种情况下可以装的最大价值是dp[i][w]
        int[][] dp = new int[N + 1][W + 1];

        // base case init 都是0 jvm已经处理

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                // 当前背包装不下
                if (w - wt[i] < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 当前背包装的下 选择最大价值的方式 有两种方式 装 或者 不装

                    //如果你没有把这第i个物品装入背包，那么很显然，最大价值dp[i][w]应该等于dp[i-1][w]。你不装嘛，那就继承之前的结果。
                    //如果你把这第i个物品装入了背包，那么dp[i][w]应该等于dp[i-1][w-wt[i-1]] + val[i-1]。
                    //而dp[i-1][w-wt[i-1]]也很好理解：你如果想装第i个物品，你怎么计算这时候的最大价值？换句话说，在装第i个物品的前提下，背包能装的最大价值是多少？
                    dp[i][w] = Math.max(dp[i - 1][w - wt[i - 1]] + val[i - 1], dp[i - 1][w]);
                }
            }
        }

        return dp[N][W];
    }


    // 子集背包问题


}
