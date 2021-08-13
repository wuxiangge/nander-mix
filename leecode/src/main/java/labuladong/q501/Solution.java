package labuladong.q501;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这个算法太low了 还有优化的空间
 * todo zhangnan
 *
 * @author zhangnan
 * @date 2021/8/13
 */
public class Solution {


    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        traceBack(root, map);
        // 在一个Map中找出值最大的k
        Integer max = Integer.MIN_VALUE;
        for (Integer value : map.values()) {
            if (value > max) {
                max = value;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue().equals(max)) {
                ans.add(integerIntegerEntry.getKey());
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    private void traceBack(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        int times = map.getOrDefault(node.val, 0);
        map.put(node.val, ++times);
        traceBack(node.left, map);
        traceBack(node.right, map);
    }


}
