package again.q05;

/**
 * @author zhangnan
 * @date 2021/8/6
 */
public class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];
        String ans = "";

        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = l + i;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

}
