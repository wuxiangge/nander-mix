package labuladong.q55;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangnan
 * @date 2021/10/9
 */
//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个下标。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// 0 <= nums[i] <= 105
//
// Related Topics 贪心 数组 动态规划
// 👍 1422 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 转换模型 最远可以跳多远 如果超过了数组的长度 则返回true
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= n - 1;
    }


    // 转换模型 最远可以跳多远 如果超过了数组的长度 则返回true

    //看了美版leetcode，说这种方法本质上是隐式(implict)BFS，
    // 我们维护一个最远能走到的距离rightmost，在维护该变量的过程中发现它的距离大于等于nums.length-1，那就能够到达末尾。
    // 如果看不太懂，放一个显式(explicit)BFS，能通过，只不过非常慢。
    public boolean canJump2(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        q.offer(0);
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                // idx is current position
                int idx = q.remove();
                // if this condition is true, we can find an answer
                if (idx >= nums.length - 1) return true;
                // i is the next rightmost position we can reach
                for (int i = idx + 1; i < nums.length &&
                        i <= idx + nums[idx]; i++) {
                    if (visited[i]) continue;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return false;
    }


    public boolean canJump3(int[] nums) {
        int length = nums.length;
        //dp[i]定义： 在nums【i】 位置可以跳的最远距离
        int[] dp = new int[length];

        for (int i = 0; i < length - 1; i++) {
            dp[i] = Math.max(dp[i], i + nums[i]);
            if (dp[i] <= i) {
                return false;
            }
        }
        return dp[length - 1] >= length - 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

