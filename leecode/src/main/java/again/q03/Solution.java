package again.q03;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangnan
 * @date 2021/8/6
 */
public class Solution {


    /**
     * 求字符串中没有重复的最长子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();

        // 最终结果的大小
        int ans = 0;

        // 右指针 开始为-1
        int rp = -1;

        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rp + 1 < n && !set.contains(s.charAt(rp + 1))) {
                set.add(s.charAt(rp + 1));
                ++rp;
            }
            ans = Math.max(ans, rp + 1 - i);
        }
        return ans;
    }

    // 滑动窗口


}
