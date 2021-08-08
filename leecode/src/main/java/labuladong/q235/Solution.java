package labuladong.q235;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangnan
 * @className Solution
 * @date 2021/8/8
 * @description //TODO
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ancestor = null;

        for (int i = 0; i < path_p.size() && i < path_q.size(); i++) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                continue;
            }
        }
        return ancestor;

    }

    private List<TreeNode> getPath(TreeNode node, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode cur = node;
        while (cur != target) {
            path.add(cur);
            if (target.val < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        path.add(cur);
        return path;
    }
}
