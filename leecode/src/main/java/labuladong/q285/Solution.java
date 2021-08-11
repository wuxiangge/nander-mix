package labuladong.q285;

/**
 * @author zhangnan
 * @date 2021/8/11
 */
public class Solution {

    private TreeNode ans = null;
    private boolean flag = false;

    /**
     * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
     * <p>
     * 节点 p 的后继是值比 p.val 大的节点中键值最小的节点。
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        traceBack(root, p);
        return ans;
    }


    private void traceBack(TreeNode node, TreeNode p) {

        if (node == null) {
            return;
        }
        traceBack(node.left, p);
        if (flag) {
            ans = node;
            flag = false;
        }

        if (p.val == node.val) {
            // 找到了节点p相等的数据
            flag = true;
        }
        traceBack(node.right, p);
    }

}
