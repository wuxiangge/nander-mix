package labuladong.q333;

/**
 * @author zhangnan
 * @date 2021/8/11
 */
public class Solution {
    private int result = 0;

    public int largestBSTSubtree(TreeNode root) {
        oneSideLargestBST(root);
        return result;
    }

    private int oneSideLargestBST(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left_value = oneSideLargestBST(node.left);
        int right_value = oneSideLargestBST(node.right);
        int ans = 0;

        if (node.left != null && node.right != null) {
            if (node.val > node.left.val && node.val < node.right.val && left_value != 0 && right_value != 0) {
                ans = left_value + right_value + 1;
            }
        } else if (node.left != null) {
            if (node.val > node.left.val && left_value != 0) {
                ans = left_value + 1;
            }
        } else if (node.right != null && right_value != 0) {
            if (node.val < node.right.val) {
                ans = right_value + 1;
            }
        } else {
            ans = 1;
        }
        result = Math.max(ans, result);
        return ans;
    }
}
