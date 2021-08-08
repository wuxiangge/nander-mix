package labuladong.q1022;

/**
 * @author zhangnan
 * @className Solution
 * @date 2021/8/8
 * @description //TODO
 */
public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        sum = (sum << 1) + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }

        return helper(node.left, sum) + helper(node.right, sum);
    }
}
