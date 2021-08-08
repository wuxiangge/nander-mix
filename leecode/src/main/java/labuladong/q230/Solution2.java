package labuladong.q230;

/**
 * @author zhangnan
 * @className Solution
 * @date 2021/8/8
 * @description //TODO
 */
public class Solution2 {

    private Integer ans = 0;
    private Integer k = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return ans;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        k--;
        if (k == 0) {
            ans = node.val;
        }
        inOrder(node.right);
    }

}
