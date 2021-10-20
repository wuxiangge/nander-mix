package ali.nowcoder.ali2021;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author zhangnan
 * @date 2021/10/19
 */
public class Main1 {


    /**
     * https://www.nowcoder.com/test/question/done?tid=49270578&qid=1664953#summary
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Main1 main1 = new Main1();
        for (int i = 1; i <= T; i++) {
            // n个物品
            int n = sc.nextInt();

            int[][] envelopers = new int[n][2];

            for (int j = 0; j < n; j++) {
                envelopers[j][0] = sc.nextInt();
            }

            for (int j = 0; j < n; j++) {
                envelopers[j][1] = sc.nextInt();
            }
            main1.maxEnvelopes(envelopers);
        }
    }


    private void maxEnvelopes(int[][] envelopers) {
        int n = envelopers.length;
        Arrays.sort(envelopers, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            }
        });


        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = envelopers[i][1];
        }

        int result = longestLis(nums);
        System.out.println(result);
    }


    /**
     * 求一个数组的最长递增子序列长度
     *
     * @param nums
     * @return
     */
    private int longestLis(int[] nums) {
        int n = nums.length;

        //定义递增子序列
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
