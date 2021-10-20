package ali.nowcoder.ali2021;

import java.util.Scanner;

/**
 * @author zhangnan
 * @date 2021/10/20
 */
public class Main2 {


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/3b6dc1447d6d4ac4b9c2d45f1d4637ea
     */

    private static double MOD = 1e9 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groups = sc.nextInt();
        while (groups-- > 0) {
            long a = sc.nextInt();
            long b = sc.nextInt();
            int n = sc.nextInt();
            a %= MOD;
            b %= MOD;
            System.out.println(new Main2().helper(a, b, n));
        }
    }


    double helper(long A, long B, int n) {
        if (n == 0) {
            return 2;
        }

        if (n == 1) {
            return A;
        }

        double[] dp = new double[n + 1];
        dp[0] = 2;
        dp[1] = A;

        for (int i = 2; i <= n; i++) {
            //减法取模公式
            dp[i] = (((A * dp[i - 1] % MOD) - (B * dp[i - 2] % MOD)) + MOD) % MOD;

        }
        return dp[n];
    }
}
