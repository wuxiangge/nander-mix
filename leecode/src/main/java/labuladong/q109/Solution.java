package labuladong.q109;

import java.util.List;

/**
 * @author zhangnan
 * @className Solution
 * @date 2021/8/7
 * @description //TODO
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    private TreeNode helper(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }

        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(left, mid);
        root.right = helper(mid.next, right);
        return root;
    }

    // 快慢指针求链表中间的节点（当链表为偶数时，时左边的那个）
    private ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
