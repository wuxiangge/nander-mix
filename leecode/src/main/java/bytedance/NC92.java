package bytedance;

import java.util.Arrays;

/**
 * @author zhangnan
 * @date 2021/10/19
 */
public class NC92 {

    /**
     * longest common subsequence
     *
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String s1, String s2) {
        // write code here
        int s1Length = s1.length();
        int s2Length = s2.length();

        int[][] dp = new int[s1Length + 1][s2Length + 1];

        for (int i = 0; i <= s1Length; i++) {
            for (int j = 0; j <= s2Length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int longest = dp[s1Length][s2Length];
        System.out.println(Arrays.deepToString(dp));
        if (longest == 0) {
            return "-1";
        }

        StringBuilder sb = new StringBuilder();
        while (s1Length > 0 && s2Length > 0) {
            if (s1.charAt(s1Length - 1) == s2.charAt(s2Length - 1)) {
                sb.append(s1.charAt(s1Length - 1));
                s1Length--;
                s2Length--;
            } else {
                if (dp[s1Length - 1][s2Length] > dp[s1Length][s2Length - 1]) {
                    s1Length--;
                } else {
                    s2Length--;
                }
            }
        }
        return sb.reverse().toString();
    }
}
