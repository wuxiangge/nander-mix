package q1392.v3;

public class Solution {


    private static long MOD = (long) (1e9 + 7);

    private static int base = 26;

    public String longestPrefix(String s) {

        int n = s.length();
        long[] pow_26 = new long[n];
        pow_26[0] = 1;
        for (int i = 1; i < n; i++) {
            pow_26[i] = pow_26[i - 1] * base % MOD;
        }

        long[] prehash = new long[n];
        long[] posthash = new long[n];

        prehash[0] = s.charAt(0) - 'a';
        for (int i = 1; i < n; i++) {
            prehash[i] = (prehash[i - 1] * base + s.charAt(i) - 'a') % MOD;
        }

        posthash[n - 1] = s.charAt(n - 1) - 'a';
        for (int i = n - 2; i >= 0; i--) {
            posthash[i] = (posthash[i + 1] + (s.charAt(i) - 'a') * pow_26[n - i - 1]) % MOD;
        }


        for (int len = s.length() - 1; len >= 1; len--) {


            // s[0...len-1] s[s.length-len s.length-1]
            if (prehash[len - 1] == posthash[n - len] && s.substring(0, len).equals(s.substring(s.length() - len))) {
                return s.substring(0, len);
            }
        }
        return "";
    }


}
