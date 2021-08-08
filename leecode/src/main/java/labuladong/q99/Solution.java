package labuladong.q99;

/**
 * @author zhangnan
 * @className Solution
 * @date 2021/8/8
 * @description //TODO
 */
public class Solution {

    private TreeNode pred = null;
    private TreeNode s = null;
    private TreeNode t = null;

    public void recoverTree(TreeNode root) {
        traverse(root);
        swap(s, t);
    }


    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        traverse(node.left);
        if (pred != null && node.val < pred.val) {
            s = (s == null) ? pred : s;
            t = node;
        }
        pred = node;
        traverse(node.right);
    }

    private void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

}
