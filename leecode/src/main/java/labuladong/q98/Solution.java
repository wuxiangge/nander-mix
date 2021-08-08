package labuladong.q98;

import sun.reflect.generics.tree.Tree;

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
    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrderContentList = new ArrayList<>();
        isValidBST(root, inOrderContentList);

        for (int i = 0; i < inOrderContentList.size() - 1; i++) {
            int pre = inOrderContentList.get(i);
            int after = inOrderContentList.get(i + 1);
            if (pre >= after) {
                return false;
            }
        }
        return true;

    }


    private void isValidBST(TreeNode node, List<Integer> inOrderContentList) {
        if (node == null) {
            return;
        }

        isValidBST(node.left, inOrderContentList);
        inOrderContentList.add(node.val);
        isValidBST(node.right, inOrderContentList);
    }


    long pre = Long.MIN_VALUE; // 记录上一个节点的值，初始值为Long的最小值

    public boolean isValidBST1(TreeNode root) {
        return inorder(root);
    }

    // 中序遍历
    private boolean inorder(TreeNode node) {
        if(node == null) {
            return true;
        }
        boolean l = inorder(node.left);
        if(node.val <= pre) {
            return false;
        }
        pre = node.val;
        boolean r = inorder(node.right);
        return l && r;
    }
}
