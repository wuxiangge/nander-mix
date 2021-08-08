package labuladong.q95;

import java.util.*;

/**
 * @author zhangnan
 * @className Solution
 * @date 2021/8/8
 * @description //TODO
 */
public class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return generateTrees(1, n);
    }


    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();

        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode curNode = new TreeNode(i);
                    curNode.left = left;
                    curNode.right = right;
                    allTrees.add(curNode);
                }
            }
        }
        return allTrees;
    }
}
