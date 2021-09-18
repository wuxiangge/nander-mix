package com.cedar.ali;


/**
 * @author zhangnan
 * @className TreeNode
 * @date 2021/9/3
 * @description //TODO
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}