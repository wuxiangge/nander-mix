package q77;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangnan
 * @date 2021/4/22 12:30
 */
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] comb = new int[k];
        int count = 0;
        backtracking(ans, comb, count, 1, n, k);
        return ans;
    }

    //
    private void backtracking(List<List<Integer>> ans, int[] comb, int count, int pos, int n, int k) {
        if (count == k) {
            List<Integer> list = Arrays.stream(comb).boxed().collect(Collectors.toList());
            ans.add(list);
            return;
        }
        for (int i = pos; i <= n; i++) {
            comb[count++] = i;
            backtracking(ans, comb, count, i + 1, n, k);
            --count;
        }
    }
}
