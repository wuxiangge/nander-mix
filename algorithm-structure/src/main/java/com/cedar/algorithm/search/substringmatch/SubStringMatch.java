package com.cedar.algorithm.search.substringmatch;

public class SubStringMatch {

    private SubStringMatch() {
    }


    public static int bruteforce(String s, String t) {

        if (s.length() < t.length()) {
            return -1;
        }

        // s[i,i+t.length-1] == t 判断s的子串是否和t相同
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



    // 字符串暴力匹配算法优化
    // 字符串转换成hash
    /**
     * code
     * hash(code) = (c*B^3 + o*B^2 + d*B^1 + e*B^0) %M
     * hash(code) = (((c*B+ o)%M *B + d)%M *B +e)%M
     *
     * int hash = 0;
     * for(int i = 0; i<s.length(); i++) {
     *     hash = (hash * B + s.charAt(i))%M;
     * }
     *
     */

}
