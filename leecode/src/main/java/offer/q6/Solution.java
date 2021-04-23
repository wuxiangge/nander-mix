package offer.q6;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangnan
 * @date 2021/4/23 10:21
 */
public class Solution {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        Deque<Integer> stack = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            stack.addFirst(cur.val);
            cur = cur.next;
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = stack.removeFirst();
        }
        return ans;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
