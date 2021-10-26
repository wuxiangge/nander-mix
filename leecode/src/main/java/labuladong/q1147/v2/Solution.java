package labuladong.q1147.v2;

/**
 * @author zhangnan
 * @date 2021/10/25
 */
public class Solution {

    private long MOD = (long) (1e9 + 7);
    long[] pow26;

    public int longestDecomposition(String text) {
        pow26 = new long[text.length()];
        pow26[0] = 1;
        for (int i = 1; i < text.length(); i++) {
            pow26[i] = pow26[i - 1] * 26 % MOD;
        }
        return dfs(text, 0, text.length() - 1);
    }

    private int dfs(String text, int left, int right) {
        if (left > right) {
            return 0;
        }

        long prehash = 0;
        long posthash = 0;
        for (int i = left, j = right; i < j; i++, j--) {
            prehash = (prehash * 26 + (text.charAt(i) - 'a')) % MOD;
            posthash = ((text.charAt(j) - 'a') * pow26[right - j] + posthash) % MOD;
            // 存在hash冲突
            if (prehash == posthash && equal(text, left, i + 1, j, right + 1)) {
                return 2 + dfs(text, i + 1, j - 1);
            }
        }
        return 1;
    }


    private boolean equal(String text, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        return text.substring(leftStart, leftEnd).equals(text.substring(rightStart, rightEnd));
    }

    public static void main(String[] args) {
        new Solution().longestDecomposition("ghiabcdefhelloadamhelloabcdefghi");
    }
}
