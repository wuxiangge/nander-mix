//如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
//
// 例如，以下数列为等差数列:
//
//
//1, 3, 5, 7, 9
//7, 7, 7, 7
//3, -1, -5, -9
//
// 以下数列不是等差数列。
//
//
//1, 1, 2, 5, 7
//
//
//
// 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
//
// 如果满足以下条件，则称子数组(P, Q)为等差数组：
//
// 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
//
// 函数要返回数组 A 中所有为等差数组的子数组个数。
//
//
//
// 示例:
//
//
//A = [1, 2, 3, 4]
//
//返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
//
// Related Topics 数学 动态规划
// 👍 233 👎 0
package q413;


import java.util.Arrays;

/**
 * @author zhangnan
 * @date 2021/4/25 16:37
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 0);

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return Arrays.stream(dp).sum();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution solution = new Solution();
        solution.numberOfArithmeticSlices(nums);
    }
}
