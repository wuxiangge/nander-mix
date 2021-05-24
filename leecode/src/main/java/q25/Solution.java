package q25;

/**
 * @author zhangnan
 * @date 2021/5/24 17:00
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode a, b;
        a = b = head;

        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }

        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }


    /**
     * 反转区间 [a, b) 的元素，注意是左闭右开
     */
    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null, next;
        ListNode cur = head;
        while (cur != tail) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
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
