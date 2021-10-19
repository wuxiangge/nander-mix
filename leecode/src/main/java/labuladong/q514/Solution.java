package labuladong.q514;

import java.util.*;

/**
 * @author zhangnan
 * @date 2021/10/11
 */
//电子游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
//
// 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
//
// 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，
//以此逐个拼写完 key 中的所有字符。
//
// 旋转 ring 拼出 key 字符 key[i] 的阶段中：
//
//
// 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符
// key[i] 。
// 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段
//）, 直至完成所有拼写。
//
//
// 示例：
//
//
//
//
//
//
//
//输入: ring = "godding", key = "gd"
//输出: 4
//解释:
// 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
// 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
// 当然, 我们还需要1步进行拼写。
// 因此最终的输出是 4。
//
//
// 提示：
//
//
// ring 和 key 的字符串长度取值范围均为 1 至 100；
// 两个字符串中都只有小写字符，并且均可能存在重复字符；
// 字符串 key 一定可以由字符串 ring 旋转拼出。
//
// Related Topics 深度优先搜索 广度优先搜索 字符串 动态规划
// 👍 213 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Map<Character, List<Integer>> charToIndexMap = new HashMap<>();

    int[][] memo;

    public int findRotateSteps(String ring, String key) {

        int m = ring.length();
        int n = key.length();

        memo = new int[m][n];

        for (int i = 0; i < ring.length(); i++) {
            charToIndexMap.putIfAbsent(ring.charAt(i), new ArrayList<>());
            charToIndexMap.get(ring.charAt(i)).add(i);
        }

        return dp(ring, 0, key, 0);
    }


    // 当指针指向ring[i]时,输入字符串key[j...]至少需要dp(ring ,i,key,j)次操作
    private int dp(String ring, int i, String key, int j) {
        if (j == key.length()) {
            return 0;
        }

        int res = Integer.MAX_VALUE;

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int n = ring.length();

        // 当前位置可以选择的下一个位置
        for (Integer index : charToIndexMap.get(key.charAt(j))) {

            int delta = Math.abs(index - i);

            delta = Math.min(delta, n - delta);

            int subProblem = dp(ring, index, key, j + 1);

            res = Math.min(res, 1 + delta + subProblem);
        }

        memo[i][j] = res;

        return res;
    }


    public int findRotateSteps2(String ring, String key) {

        int m = ring.length();
        int n = key.length();

        Map<Character, List<Integer>> charToIndexListMap = new HashMap<>();

        for (int i = 0; i < ring.length(); i++) {
            charToIndexListMap.putIfAbsent(ring.charAt(i), new ArrayList<>());
            charToIndexListMap.get(ring.charAt(i)).add(i);
        }


        // 定义 dp[i][j] 表示从前往后拼写出 key 的第 i 个字符， ring 的第 j == List<> 个字符与 12:00 方向对齐的最少步数（下标均从 00 开始）。
        int[][] dp = new int[n][m];

        for (Integer index : charToIndexListMap.get(key.charAt(0))) {
            dp[0][index] = Math.min(index, n - index) + 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j : charToIndexListMap.get(key.charAt(i))) {
                for (int k : charToIndexListMap.get(key.charAt(i - 1))) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }


}
//leetcode submit region end(Prohibit modification and deletion)
