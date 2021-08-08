package labuladong.q230;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangnan
 * @className Solution
 * @date 2021/8/8
 * @description //TODO
 */
public class Solution {

    private List<Integer> inOrderList = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return inOrderList.get(k - 1);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        inOrderList.add(node.val);
        inOrder(node.right);
    }

}
