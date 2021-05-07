package q102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhangnan
 * @date 2021-04-29 21:28
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int currentSize = queue.size();

            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < currentSize; i++) {
                TreeNode frontNode = queue.poll();

                currentLevel.add(frontNode.val);

                if (frontNode.left != null) {
                    queue.offer(frontNode.left);
                }
                if (frontNode.right != null) {
                    queue.offer(frontNode.right);
                }
                ans.add(currentLevel);
            }
        }
        return ans;
    }


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
}
