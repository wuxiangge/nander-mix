package labuladong.q46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangnan
 * @className Solution
 * @date 2021/8/16
 * @description //TODO
 */
public class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(nums, track);
        return ans;
    }


    private void backtrack(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            ans.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.remove(track.size() - 1);

        }
    }

}
