package labuladong.q333;

/**
 * @author zhangnan
 * @date 2021/8/11
 */
public class Solution {

    private Integer result = 0;

    public int largestBSTSubtree(TreeNode root) {
        oneSideLargestBST(root);
        return result;
    }

    private NodeInfo oneSideLargestBST(TreeNode node) {
        NodeInfo nodeInfo = new NodeInfo();
        if (node == null) {
            nodeInfo.isBst = true;
            return nodeInfo;
        }

        NodeInfo leftNodeInfo = oneSideLargestBST(node.left);
        NodeInfo rightNodeInfo = oneSideLargestBST(node.right);
        int minValue = Math.min(node.val, Math.min(leftNodeInfo.min, rightNodeInfo.min));
        int maxValue = Math.max(node.val, Math.max(leftNodeInfo.max, rightNodeInfo.max));
        int nodeCount = leftNodeInfo.size + rightNodeInfo.size + 1;
        boolean flag = (leftNodeInfo.isBst && rightNodeInfo.isBst && node.val > leftNodeInfo.max && node.val < rightNodeInfo.min);
        if (flag) {
            result = Math.max(nodeCount, result);
        }
        nodeInfo.isBst = flag;
        nodeInfo.min = minValue;
        nodeInfo.max = maxValue;
        nodeInfo.size = nodeCount;
        return nodeInfo;
    }


    static class NodeInfo {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int size = 0;
        boolean isBst = false;

        public NodeInfo() {
        }
    }
}
