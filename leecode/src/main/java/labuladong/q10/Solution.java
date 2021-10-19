package labuladong.q10;

/**
 * @author zhangnan
 * @date 2021/10/12
 */
//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
//
// '.' 匹配任意单个字符
// '*' 匹配零个或多个前面的那一个元素
//
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//
//
// 示例 1：
//
//
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
//
//
// 示例 2:
//
//
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
//
//
// 示例 3：
//
//
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
//
//
// 示例 4：
//
//
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
//
//
// 示例 5：
//
//
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false
//
//
//
// 提示：
//
//
// 1 <= s.length <= 20
// 1 <= p.length <= 30
// s 可能为空，且只包含从 a-z 的小写字母。
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
// 保证每次出现字符 * 时，前面都匹配到有效的字符
//
// Related Topics 递归 字符串 动态规划
// 👍 2433 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }

    //    dp(s,i,p,j) = true，则表示s[i..]可以匹配p[j..]；若dp(s,i,p,j) = false，则表示s[i..]无法匹配p[j..]。
    boolean dp(String s, int i, String p, int j) {
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                return dp(s, i, p, j + 2) || dp(s, i + 1, p, j);

            } else {
                return dp(s, i + 1, p, j + 1);
            }
        } else {
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                return dp(s, i, p, j + 2);
            } else {
                return false;
            }
        }
    }


    public boolean isMatch2(String s, String p) {

        int m = s.length();
        int n = p.length();


        // dp[i][j] s的前i个字符与p中前j个字符是否匹配
        boolean f[][] = new boolean[m + 1][n + 1];

        f[0][0] = true;
        //f[0][0]代表s和p均为空字符串，f[1][1]代表s和p的第一个字符（即在s和p中下标为0的字符）
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {//p的第j个字符为*
                    if (matches(s, p, i, j - 1)) {//匹配s的第i个字符和p的第j-1个字符
                        f[i][j] = f[i - 1][j] || f[i][j - 2];//p中*前面的字符在s中出现多次或者在s中只出现1次
                    } else {
                        f[i][j] = f[i][j - 2];//p中*前面的在s中字符出现0次
                    }
                } else {//p的第j个字符不为*
                    if (matches(s, p, i, j)) {//匹配s的第i个字符和p的第j个字符
                        f[i][j] = f[i - 1][j - 1];//匹配成功，状态转移；匹配不成功，默认是false
                    }
                }
            }
        }
        return f[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean flag = solution.isMatch2("aaa", " ");
        System.out.println(flag);
    }


    private boolean matches(String s, String p, int i, int j) {

        //注意在字符串中的下标变换
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
