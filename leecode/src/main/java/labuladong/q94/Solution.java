package labuladong.q94;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangnan
 * @className Solution
 * @date 2021/8/8
 * @description //TODO
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans;
    }

    private void inOrder(TreeNode node, List<Integer> ans) {

        if (node == null) {
            return;
        }
        inOrder(node.left, ans);
        ans.add(node.val);
        inOrder(node.right, ans);
    }


    public List<Integer> inorderUseStack(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root.left);
                root = root.left;
            }

            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    private void preOrder(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }

        ans.add(node.val);
        preOrder(node.left, ans);
        preOrder(node.right, ans);
    }

    private List<Integer> preOrderUseStack(TreeNode node) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return ans;
    }


}
