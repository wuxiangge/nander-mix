package labuladong.q270;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangnan
 * @className Solution
 * @date 2021/8/8
 * @description //TODO
 */
public class Solution {
    private double pred = Double.MAX_VALUE;
    private int ans = 0;

    public int closestValue(TreeNode root, double target) {
        traceback(root, target);
        return ans;
    }

    private void traceback(TreeNode node, double target) {
        if (node == null) {
            return;
        }

        traceback(node.left, target);
        double abs = Math.abs(target - node.val);
        if (abs < pred) {
            pred = abs;
            ans = node.val;
        }
        traceback(node.right, target);
    }


    public int closestValueUseStack(TreeNode root, double target) {
        Deque<TreeNode> stack = new LinkedList<>();
        long pred = Long.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred <= target && target < root.val) {
                return Math.abs(pred - target) < Math.abs(root.val - target) ? (int) pred : root.val;
            }
            pred = root.val;
            root = root.right;
        }
        return (int) pred;
    }


}
