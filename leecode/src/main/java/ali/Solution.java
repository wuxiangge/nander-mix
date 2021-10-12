package ali;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zhangnan
 * @className Solution
 * @date 2021/9/3
 * @description //TODO
 */
public class Solution {

    /**
     * 判断一个二叉树从根节点到叶子节点的和等于给定的目标值
     *
     * @param root
     * @param target
     * @return
     */
    public boolean detectedOneSideSumEqualTarget(TreeNode root, int target) {

        // base case
        if (root == null) {
            return false;
        }

        target = target - root.val;

        // 如果当前的值为0 并且当前节点为空 那么找到一个可行解
        if (target == 0 && root.left == null && root.right == null) {
            return true;
        }

        return detectedOneSideSumEqualTarget(root.left, target) || detectedOneSideSumEqualTarget(root.right, target);
    }

    List<List<Integer>> result = new ArrayList<>();


    /**
     * 判断一个二叉树从根节点到叶子节点的和等于给定的目标值
     *
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> obtainSideSumEqualTarget(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        dfs(root, 0, target, new ArrayList<>());
        return result;
    }


    private void dfs(TreeNode node, int nowSum, int target, List<Integer> path) {
        // 终止条件
        path.add(node.val);
        if (node.left == null && node.right == null && nowSum + node.val == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (node.left != null) {
            dfs(node.left, nowSum + node.val, target, path);
            path.remove(path.size() - 1);
        }

        if (node.right != null) {
            dfs(node.right, nowSum + node.val, target, path);
            path.remove(path.size() - 1);
        }
    }

}

