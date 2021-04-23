package offer.q3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangnan
 * @date 2021/4/23 9:34
 */
public class Solution {

    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("传入的数字不包含重复数字");
        }

        int n = nums.length;
        Set<Integer> set = new HashSet();

        for (int i = 0; i < n; i++) {
            boolean flag = set.add(nums[i]);
            if (!flag) {
                return nums[i];
            }
        }
        throw new IllegalArgumentException("传入的数字不包含重复数字");
    }
}
