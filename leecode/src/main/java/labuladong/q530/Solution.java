package labuladong.q530;

/**
 * @author zhangnan
 * @date 2021/8/13
 */
public class Solution {

    private Integer pred;
    private int ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traceBack(root);
        return ans;
    }

    private void traceBack(TreeNode node) {
        if (node == null) {
            return;
        }

        traceBack(node.left);
        if (pred != null) {
            ans = Math.min(ans, Math.abs(pred - node.val));
        }
        pred = node.val;
        traceBack(node.right);
    }

}
