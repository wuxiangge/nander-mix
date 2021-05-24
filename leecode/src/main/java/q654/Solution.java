package q654;

/**
 * @author zhangnan
 * @date 2021/5/24 19:33
 */
public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }


    //    [lo...hi]
    public TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }


        int index = -1;
        int maxValue = Integer.MIN_VALUE;

        for (int i = lo; i <= hi; i++) {
            if (maxValue < nums[i]) {
                index = i;
                maxValue = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxValue);
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;
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
