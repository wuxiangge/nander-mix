package q72;
//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作：
//
//
// 插入一个字符
// 删除一个字符
// 替换一个字符
//
//
//
//
// 示例 1：
//
//
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//
//
// 示例 2：
//
//
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//
//
//
//
// 提示：
//
//
// 0 <= word1.length, word2.length <= 500
// word1 和 word2 由小写英文字母组成
//
// Related Topics 字符串 动态规划
// 👍 1852 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // base case init
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }


    public int minDistance2(String word1, String word2) {

        /**
         * if s1[i] == s2[j]:
         *     啥都别做（skip）
         *     i, j 同时向前移动
         * else:
         *     三选一：
         *         插入（insert）
         *         删除（delete）
         *         替换（replace）
         */
        int m = word1.length();
        int n = word2.length();

        // 定义dp[i][j]
        // 存储word1[0...i] 和 word2[0....j] 最小编辑距离

        //        '' r o s
        //   ''   0  1 2 3
        //   h    1  1 2 3
        //   o    2  2 1 2
        //   r    3  2 2 2
        //   s    4  3 3 2
        //   e    5  4 4 3

        // 定义dp[i][j]
        // 存储word1[0...i] 和 word2[0....j] 最小编辑距离
        int[][] dp = new int[m + 1][n + 1];

        // base case
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j - 1], //替换
                            dp[i][j - 1],   //插入
                            dp[i - 1][j]    //删除
                    ) + 1;
                }
            }
        }
        return dp[m][n];
    }


    /**
     * 取出三个值中的最小值
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
//leetcode submit region end(Prohibit modification and deletion)