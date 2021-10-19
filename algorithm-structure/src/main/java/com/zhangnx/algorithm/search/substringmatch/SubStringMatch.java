package com.zhangnx.algorithm.search.substringmatch;

public class SubStringMatch {

    private SubStringMatch() {
    }

    /**
     * 字符串匹配
     * 暴力破解法
     *
     * @param s 字符串
     * @param t 子串
     * @return 返回匹配的字符
     */
    public static int bruteforce(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        if (tLength > sLength) {
            return -1;
        }

        // abababab    8
        //      bab    3
        //
        for (int i = 0; i + tLength <= sLength; i++) {
            int j = 0;
            for (; j < tLength; j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    break;
                }
            }
            if (j == tLength) {
                return i;
            }
        }
        return -1;
    }






}
