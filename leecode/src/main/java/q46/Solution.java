package q46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangnan
 * @date 2021/4/22 11:15
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(nums, 0, ans);
        return ans;
    }

    // 回溯法
    private void backtracking(int[] nums, int level, List<List<Integer>> ans) {
        if (level == nums.length - 1) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            ans.add(list);
            return;
        }

        for (int i = level; i < nums.length; i++) {
            swap(nums, i, level);
            backtracking(nums, level + 1, ans);
            swap(nums, i, level);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
