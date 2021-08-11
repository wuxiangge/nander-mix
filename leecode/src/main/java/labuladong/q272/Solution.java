package labuladong.q272;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangnan
 * @date 2021/8/11
 */
public class Solution {

    private Deque<Integer> ans = new LinkedList<>();

    private int global_k = 0;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        this.global_k = k;
        backTrace(root, target);
        return new ArrayList<>(ans);
    }

    private void backTrace(TreeNode node, double target) {
        if (node == null) {
            return;
        }

        backTrace(node.left, target);
        // 中序遍历
        if (global_k > 0) {
            ans.addLast(node.val);
            global_k--;
        } else {
            // 当有新的元素可以加入时 开始从这个列表中排除已经有的元素
            Integer ans_first = ans.getFirst();
            if (Math.abs(target - ans_first) > Math.abs(target - node.val)) {
                ans.removeFirst();
                ans.addLast(node.val);
            }
        }


        backTrace(node.right, target);
    }

}
