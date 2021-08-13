package labuladong.q510;

/**
 * 这个算法太low了 还有优化的空间
 *
 * @author zhangnan
 * @date 2021/8/13
 * <p>
 * 2
 * 1 3
 */
public class Solution {


    private Node predNode = null;
    private Node ans = null;
    private boolean flag = false;

    public Node inorderSuccessor(Node node) {
        this.predNode = node;
        // 找到根节点
        Node root = node;
        while (root.parent != null) {
            root = root.parent;
        }
        inorder(root);
        return ans;
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (flag) {
            ans = node;
            flag = false;
        }
        if (predNode == node) {
            flag = true;
        }
        inorder(node.right);
    }

//              5
//            3   6
//          2   4
//        1
//
//                    15
//                  6             18
//               3    7       17     20
//              2  4    13
//                   9
//
//

}
