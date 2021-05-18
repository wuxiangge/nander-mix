package q76;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//
//
// 示例 1：
//
//
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//
//
// 示例 2：
//
//
//输入：s = "a", t = "a"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 105
// s 和 t 由英文字母组成
//
//
//
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 1120 👎 0

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String minWindow(String s, String t) {
        // 双指针法

        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
            // 边界条件
            return "";
        }

        int tLength = t.length();
        // 还可以使用数组来映射字符 ascII
        Map<Character, Integer> tMap = new HashMap<>(t.length());
        Map<Character, Integer> sMap = new HashMap<>(s.length());

        for (int i = 0; i < tLength; i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // 双指针处理字符串
        int l = 0;
        int min_l = 0;
        int min_size = s.length() + 1;
        int cnt = 0;

        for (int r = 0; r < s.length(); ++r) {
            char c = s.charAt(r);
            if (tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                if (sMap.get(c) <= tMap.get(c)) {
                    ++cnt;
                }
            }

            // 这里发生了什么 表明当前窗口已经包含了全部的需要的字符
            // 现在开始尝试移动l 向右移动会发生什么
            while (cnt == tLength) {
                if (r - l + 1 < min_size) {
                    min_l = l;
                    min_size = r - l + 1;
                }
                char sc = s.charAt(l);
                if (tMap.containsKey(sc) && sMap.get(sc) > 0) {
                    sMap.put(sc, sMap.get(sc) - 1);
                    if (sMap.get(sc) < tMap.get(sc)) {
                        --cnt;
                    }
                }
                ++l;
            }
        }


        return min_size > s.length() ? "" : s.substring(min_l, min_l + min_size);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
    }
}
