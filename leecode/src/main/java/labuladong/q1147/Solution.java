package labuladong.q1147;

/**
 * @author zhangnan
 * @date 2021/10/25
 */
public class Solution {

    public int longestDecomposition(String text) {
        return dfs(text, 0, text.length() - 1);
    }

    private int dfs(String text, int left, int right) {
        if (left > right) {
            return 0;
        }

        for (int i = left, j = right; i < j; i++, j--) {
            if (text.substring(left, i + 1).equals(text.substring(j, right + 1))) {
                return 2 + dfs(text, i + 1, j - 1);
            }
        }
        return 1;
    }


    public int longestDecomposition2(String text) {
        int n = text.length();
        return dfs2(0, n - 1, text);
    }


    int dfs2(int begin, int end, String text) {
        if (begin > end) {
            return 0;
        }

        int j = end;
        while (j > begin) {
            int len = end - j + 1;

            String left = text.substring(begin, begin + len);
            String right = text.substring(j, len + j);

            if (left.equals(right)) {
                return 2 + dfs2(begin + len, j - 1, text);
            }

            j--;
        }
        return 1;
    }


    public static void main(String[] args) {
        new Solution().longestDecomposition("abc");
    }


}
