package offer.q6.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangnan
 * @date 2021/4/23 10:21
 */
public class Solution {

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        recursion(head, list);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }


    private void recursion(ListNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        recursion(node.next, list);
        list.add(node.val);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
