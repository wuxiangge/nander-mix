package offer.q48;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangnan
 * @date 2021/10/20
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, set.size());
        }
        return maxLen;
    }

}
