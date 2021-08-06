package again.q01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangnan
 * @date 2021/8/6
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        //解决思路
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }

        // O(n)
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }
            int anotherAddParam = target - num;
            map.put(anotherAddParam, i);
        }
        return new int[]{-1, -1};
    }

}
