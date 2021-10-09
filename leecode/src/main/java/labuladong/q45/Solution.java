package labuladong.q45;

import java.util.Arrays;

/**
 * @author zhangnan
 * @date 2021/10/9
 */
//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
// 假设你总是可以到达数组的最后一个位置。
//
//
//
// 示例 1:
//
//
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//
//
// 示例 2:
//
//
//输入: nums = [2,3,0,1,4]
//输出: 2
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 104
// 0 <= nums[i] <= 1000
//
// Related Topics 贪心 数组 动态规划
// 👍 1201 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] memo;

    public int jump(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, n);

        return dp(nums, 0);
    }

    /**
     * 定义从索引p 跳到最后一步需要的次数
     *
     * @param nums
     * @param p
     * @return
     */
    int dp(int[] nums, int p) {

        int n = nums.length;

        if (p >= n - 1) {
            return 0;
        }

        // 如果子问题已经计算过
        if (memo[p] != n) {
            return memo[p];
        }


        int steps = nums[p];

        for (int i = 1; i <= steps; i++) {
            int subProblem = dp(nums, p + i);
            memo[p] = Math.min(memo[p], subProblem + 1);
        }
        return memo[p];
    }


    public int jump2(int[] nums) {
        int n = nums.length;

        // dp[i]定义:对于num[i]来到该位置的最小跳跃次数
        int[] dp = new int[n];
        // base case
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] < i) {
                    continue;
                } else {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    public int jump3(int[] nums) {
        int n = nums.length;
        int end = 0;
        int farthest = 0;
        int jumps = 0;

        //i和end标记了可以选择的跳跃步数，farthest标记了所有可选择跳跃步数[i..end]中能够跳到的最远距离，jumps记录了跳跃次数。
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }

}
//leetcode submit region end(Prohibit modification and deletion)