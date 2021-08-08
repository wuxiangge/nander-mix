package labuladong.q105;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangnan
 * @className Solution
 * @date 2021/8/7
 * @description //TODO
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
        // [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
        Map<Integer, Integer> inMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, inMap);

    }

    private TreeNode buildTree(int[] preOrder, int preStart, int preEnd,
                               int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 前序遍历的的第一个元素为根节点
        int pre_order_root = preOrder[preStart];
        TreeNode root = new TreeNode(pre_order_root);
        int in_order_root_index = inMap.get(pre_order_root);
        int left_tree_size = in_order_root_index - inStart;


        root.left = buildTree(preOrder, preStart + 1, preStart + left_tree_size,
                inOrder, inStart, in_order_root_index - 1, inMap);

        root.right = buildTree(preOrder, preStart + left_tree_size + 1, preEnd,
                inOrder, in_order_root_index + 1, inEnd, inMap);


        return root;
    }
}
