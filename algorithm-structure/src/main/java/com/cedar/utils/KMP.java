package com.cedar.utils;

/**
 * KMP算法的由来
 *
 * @author zhangnan
 * @date 2021/8/5
 */
public class KMP {

    public int bruteForce(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        for (int i = 0; i < lenS - lenP; i++) {
            boolean flag = true;
            for (int j = 0; j < lenP; j++) {
                if (s.charAt(i + j) != s.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }


}
