package ali.nowcoder.ali2021;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangnan
 * @date 2021/10/20
 */
public class Main3 {


    public static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        // dp[i][j]表示i个节点最大深度为j的树数量
        long[][] dp = new long[n + 1][m + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    // 左子树节点数为k，右子树节点数为i-k-1，且左右子树都要求小于等于j-1
                    dp[i][j] = (dp[i][j] + dp[k][j - 1] * dp[i - k - 1][j - 1] % MOD) % MOD;
                }
            }
        }
        System.out.println(dp[n][m]);
    }

    /**
     * n 节点个数
     * m 二叉树高度
     *
     * @param n
     * @param m
     * @return
     */
    private long helper(int n, int m) {
        // dp[i][j]表示i个节点最大深度为j的树数量
        long[][] dp = new long[n + 1][m + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    // 左子树节点数为k，右子树节点数为i-k-1，且左右子树都要求小于等于j-1
                    dp[i][j] = (dp[i][j] + dp[k][j - 1] * dp[i - k - 1][j - 1] % MOD) % MOD;
                }
            }
        }
        return dp[n][m];
    }


}
