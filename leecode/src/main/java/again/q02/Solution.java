package again.q02;

/**
 * @author zhangnan
 * @date 2021/8/6
 */
public class Solution {
    private static final Integer TEN_NUMBER = 10;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建一个链表用来承载结果集
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;

        ListNode p = l1;
        ListNode q = l2;

        // 定义一个常量来表示进位数字
        int carry = 0;

        // 开始遍历链表
        while (p != null || q != null) {
            int pVal = p != null ? p.val : 0;
            int qVal = q != null ? q.val : 0;

            // 计算两数字相加是否进位
            int sum = pVal + qVal + carry;
            // 开始计算进位和余数
            carry = sum / TEN_NUMBER;
            prev.next = new ListNode(sum % TEN_NUMBER);
            prev = prev.next;

            // 递推
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        // 处理进位
        if (carry != 0) {
            prev.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


}
