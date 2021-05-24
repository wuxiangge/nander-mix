package q234;

/**
 * @author zhangnan
 * @date 2021/5/24 18:29
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    ListNode left;

    private boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean flag = traverse(right.next);
        flag = flag && right.val == left.val;
        left = left.next;
        return flag;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


    }
}


