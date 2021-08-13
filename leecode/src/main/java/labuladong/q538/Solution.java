package labuladong.q538;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangnan
 * @date 2021/8/13
 */

//给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于
// node.val 的值之和。
//
// 提醒一下，二叉搜索树满足下列约束条件：
//
//
// 节点的左子树仅包含键 小于 节点键的节点。
// 节点的右子树仅包含键 大于 节点键的节点。
// 左右子树也必须是二叉搜索树。
//
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-s
//um-tree/ 相同
//
//
//
// 示例 1：
//
//
//
// 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
//                   4
//             1           6
//         0      2     5      7
//              3                 8
//                   30
//            36           21
//         36    35     26      15
//             33                  8
//
// 示例 2：
//
// 输入：root = [0,null,1]
//输出：[1,null,1]
//
//
// 示例 3：
//
// 输入：root = [1,0,2]
//输出：[3,3,2]
//
//
// 示例 4：
//
// 输入：root = [3,2,4,1]
//输出：[7,9,4,10]
//
//
//
//
// 提示：
//
//
// 树中的节点数介于 0 和 104 之间。
// 每个节点的值介于 -104 和 104 之间。
// 树中的所有值 互不相同 。
// 给定的树为二叉搜索树。
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树
// 👍 567 👎 0

public class Solution {

    public TreeNode convertBST(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        calculateNodeValue(root, inorderList);
        Map<Integer, Integer> weight = new HashMap<>();
        for (int i = inorderList.size() - 1; i >= 0; i--) {
            if (i == inorderList.size() - 1) {
                weight.put(inorderList.get(i), inorderList.get(i));
            } else {
                weight.put(inorderList.get(i), inorderList.get(i) + weight.get(inorderList.get(i + 1)));
            }
        }
        flushBSTTree(root, weight);
        return root;
    }

    private void flushBSTTree(TreeNode node, Map<Integer, Integer> weight) {
        if (node == null) {
            return;
        }

        flushBSTTree(node.left, weight);
        node.val = weight.get(node.val);
        flushBSTTree(node.right, weight);
    }


    private void calculateNodeValue(TreeNode node, List<Integer> inorderList) {
        if (node == null) {
            return;
        }
        calculateNodeValue(node.left, inorderList);
        inorderList.add(node.val);
        calculateNodeValue(node.right, inorderList);
    }
}
