package cmbnt;

/**
 * @author zhangnan
 * @date 2021/10/19
 */
public class Solution {

    /**
     * 有两个长度均为n，的数组a，b，从a数组头或尾取出一个数，
     * 假设第i次取的值为ax,那么第i次的价值为b[i - 1]*ax，
     * 价值总和为前i-1次价值之和加上第i次的价值，求第n次取数最大价值总和
     *
     * @param nums int整型一维数组
     * @param values int整型一维数组
     * @return int整型
     */
    int result = 0;

    public int getMaxValue(int[] nums, int[] values) {
        int n = nums.length;
        backtrack(nums, values, 0, n - 1, 1, 0);
        return result;
    }


    // 回溯算法
    void backtrack(int[] nums, int[] values, int left, int right, int times, int maxValue) {
        if (times == nums.length + 1) {
            result = Math.max(result, maxValue);
            return;
        }

        // 开始做选择
        maxValue = maxValue + nums[left] * values[times - 1];
        backtrack(nums, values, left + 1, right, times + 1, maxValue);
        // 撤销选择
        maxValue = maxValue - nums[left] * values[times - 1];


        maxValue = maxValue + nums[right] * values[times - 1];
        backtrack(nums, values, left, right - 1, times + 1, maxValue);
        maxValue = maxValue - nums[right] * values[times - 1];
    }


    public int getMaxValue2(int[] nums, int[] values) {

        int len = nums.length;
        int[][] dp = new int[len][len];

        // dp[i][j]表示 从nums数组 [i,j]获取的最大值
        // dp[i][j] = max(dp[i + 1][j] + nums[i] * values[time], dp[i][j - 1] + nums[j] * values[time])
        for (int l = 0; l < len; l++) {
            for (int i = 0; i < len; i++) {
                int j = i + l;
                if (j >= len) break;
                if (l == 0) {
                    dp[i][j] = nums[i] * values[len - 1 - l];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j] + nums[i] * values[len - 1 - l], dp[i][j - 1] + nums[j] * values[len - 1 - l]);
                }
            }
        }
        return dp[0][len - 1];
    }


    public int getMaxValues3(int[] nums, int[] values) {
        int length = nums.length;

        int[][] dp = new int[length][length];
        // 定义dp[i][j] 从数组的nums[i,j]获取的最大值
        for (int l = 0; l < length; l++) {
            for (int i = 0; i < length; i++) {
                int j = i + l;
                if (j >= length) {
                    break;
                }
                if (l == 0) {
                    dp[i][j] = nums[i] * values[length - 1 - l];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j] + nums[i] * values[length - 1 - l], dp[i][j - 1] + nums[j] * values[length - 1 - l]);
                }
            }
        }
        return dp[0][length - 1];
    }

}
