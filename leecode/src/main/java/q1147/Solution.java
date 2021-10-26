package q1147;

public class Solution {


    public int longestDecomposition(String text) {
        int n = text.length();
        return dfs(0, n - 1, text);
    }


    int dfs(int begin, int end, String text) {
        if (begin > end) {
            return 0;
        }

        int j = end;
        while (j > begin) {
            int len = end - j + 1;

            String left = text.substring(begin, begin + len);
            String right = text.substring(j, len + j);

            if (left.equalsIgnoreCase(right)) {
                return 2 + dfs(begin + len, j - 1, text);
            }

            j--;
        }


        return 1;
    }

    public static void main(String[] args) {
        double pow = Math.pow(2, 4);
        System.out.println(pow);
    }

    public long fastPower(long a, long b) {
        long ans = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                ans = (ans * a);
            }
            b >>= 1;
            a = (a * a);
        }
        return ans;
    }

    public long fastPowerMod(long a, long b, long c) {
        long ans = 1;
        a %= c;
        while (b != 0) {
            if ((b & 1) == 1) {
                ans = (ans * a) % c;
            }
            b >>= 1;
            a = (a * a) % c;
        }
        return ans;
    }
}
