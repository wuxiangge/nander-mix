package again.q05;

/**
 * @author zhangnan
 * @date 2021/8/6
 */
public class Solution {

    //给你一个字符串 s，找到 s 中最长的回文子串。
    //
    //
    //
    // 示例 1：
    //
    //
    //输入：s = "babad"
    //输出："bab"
    //解释："aba" 同样是符合题意的答案。
    //
    //
    // 示例 2：
    //
    //
    //输入：s = "cbbd"
    //输出："bb"
    //
    //
    // 示例 3：
    //
    //
    //输入：s = "a"
    //输出："a"
    //
    //
    // 示例 4：
    //
    //
    //输入：s = "ac"
    //输出："a"
    //
    //
    //
    //
    // 提示：
    //
    //
    // 1 <= s.length <= 1000
    // s 仅由数字和英文字母（大写和/或小写）组成
    //
    // Related Topics 字符串 动态规划
    // 👍 4175 👎 0

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }


    // 找到最长回文串
    private String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        // 左闭右开
        return s.substring(l + 1, r);
    }
    // 012
    // aba
    // -1 3

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestPalindrome("babad");
    }

}
