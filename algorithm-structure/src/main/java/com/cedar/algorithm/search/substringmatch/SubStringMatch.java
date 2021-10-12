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

}
