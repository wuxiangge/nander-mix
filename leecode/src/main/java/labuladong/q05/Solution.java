package labuladong.q05;

/**
 * @author zhangnan
 * @date 2021/10/19
 */
public class Solution {


    /**
     * for(int i = 0;i<length(s);i++) {
     * 以i为中心的回文串
     * 以i和i+1为中心的回文串
     * 更新答案
     * }
     *
     * @param s
     * @return
     */

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palidrome(s, i, i);
            String s2 = palidrome(s, i, i + 1);

            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private String palidrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }


    // 动态规划解法
    public String longestPalindrome2(String s) {
        int n = s.length();

        if (n < 2) {
            return s;
        }

        // 记录最大的长度
        int maxLen = 1;
        // 记录开始值
        int begin = 0;

        // dp[i][j] 定义：dp[i+1][j-1]是回文子串 判断dp[i][j]
        boolean[][] dp = new boolean[n][n];

        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n; i++) {
                int j = l + i - 1;
                if (j >= n) {
                    break;
                }

                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


}
