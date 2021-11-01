package labuladong.q1392;

/**
 * @author zhangnan
 * @date 2021/10/25
 */
public class Solution {


    /**
     * 方法一：Rabin-Karp 字符串编码
     * 背景知识
     * Rabin-Karp 字符串编码是一种将字符串映射成整数的编码方式，可以看成是一种哈希算法。具体地，假设字符串包含的字符种类不超过 |\Sigma|∣Σ∣（其中 \SigmaΣ 表示字符集），那么我们选一个大于等于 |\Sigma|∣Σ∣ 的整数 \textit{base}base，就可以将字符串看成 \textit{base}base 进制的整数，将其转换成十进制数后，就得到了字符串对应的编码。
     * 例如给定字符串 s = abcas=abca，其包含的字符种类为 33（即 abcabc 三种）。我们取 \textit{base} = 9base=9，将字符串 ss 看成九进制数 (0120)_9(0120)
     * ​
     * ，转换为十进制为 9999，也就是说字符串 abcaabca 的编码为 9999。一般地，计算编码值的公式如下：
     * <p>
     *
     * @param s
     * @return
     */


    private static long MOD = (long) (1e7 + 9);

    private static int base = 26;

    public String longestPrefix(String s) {
        int n = s.length();

        long prefix = 0;
        long suffix = 0;

        long[] pow_26 = new long[n];
        pow_26[0] = 1;
        for (int i = 1; i < n; i++) {
            pow_26[i] = pow_26[i - 1] * base % MOD;
        }

        int happy = 0;

        for (int i = 1; i < n; i++) {
            prefix = (prefix * base + (s.charAt(i - 1) - 'a')) % MOD;
            suffix = (suffix + (s.charAt(n - i) - 'a') * pow_26[i - 1]) % MOD;
            if (prefix == suffix) {
                happy = i;
            }
        }

        return s.substring(0, happy);
    }

}
