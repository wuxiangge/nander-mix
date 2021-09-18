package labuladong.q23;

import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    // 这一题考查的问题是如何快速取出多个链表中第一个值最小的链表
    // 推荐使用优先队列
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b) -> (a.val - b.val));

        for (ListNode listNode : lists) {
            if (listNode != null) {
                pq.offer(listNode);
            }
        }


        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummyHead.next;
    }






}
