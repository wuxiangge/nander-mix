package com.cedar.algorithm.search.substringmatch;

/**
 * 字符串的匹配
 * <p>
 * 暴力搜索法
 * 哈希法
 *
 * @author zhangnan
 * @date 2021/9/30
 */
public class SubStringMatch {

    // 0123456
    // ABCDEFG
    // 012
    // EFG


    private SubStringMatch() {

    }


    /**
     * 字符串匹配算法
     *
     * @param s source
     * @param t target
     * @return
     */
    public static int bruteforce(String s, String t) {

        if (t.length() > s.length()) {
            return -1;
        }

        for (int i = 0; i + t.length() - 1 < s.length(); i++) {
            int j = 0;
            for (; j < t.length(); j++) {
                if (s.charAt(i + j) != t.charAt(j)) {
                    break;
                }
            }
            if (j == t.length()) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 字符串暴力匹配的改进思路
     *
     * hash思想
     * 每一次匹配在最差的情况下，重新扫描一遍字符串t
     * 比较连个字符串相等O(n)
     * 比较连个整形是否相等O(1)
     * 字符串转整形 哈希
     *
     *
     *
     */


}
