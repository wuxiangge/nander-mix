package com.cedar.io.remote;

/**
 * @author zhangnan
 * @date 2021/1/12 14:23
 */
public class ByteUtils {

    public static int bytes2int(byte[] b, int start, int len) {
        int sum = 0;
        int end = start + len;
        for (int i = start; i < end; i++) {
            int n = ((int) b[i]) & 0xff;
            n <<= (--len) * 8;
            sum = n + sum;
        }
        return sum;
    }


}
