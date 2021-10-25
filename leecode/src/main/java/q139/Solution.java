package q139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangnan
 * @date 2021/10/21
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordDictSet = new HashSet<>(wordDict);

        /**
         * dp[i]表示字符串s前i个字符组成的字符串s[0...i-1]是否能被空格拆分成若干个字典中出现的单词
         * 状态转移方程
         *
         */
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            for (String o : wordDict) {
                int len = o.length();
                // 以i为头
                // if(n-i>=len && s.substring(i, i+len).equals(o)){
                //     dp[i+len] |= dp[i];
                // }
                // 以i为尾
                if (i >= len && s.substring(i - len, i).equals(o)) {
                    dp[i] |= dp[i - len];
                    if (dp[i]) {
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}
