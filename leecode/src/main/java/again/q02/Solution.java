package again.q02;

/**
 * @author zhangnan
 * @date 2021/8/6
 */
public class Solution {
    private static final Integer TEN_NUMBER = 10;


    //给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    //
    // 请你将两个数相加，并以相同形式返回一个表示和的链表。
    //
    // 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    //
    //
    //
    // 示例 1：
    //
    //
    //输入：l1 = [2,4,3], l2 = [5,6,4]
    //输出：[7,0,8]
    //解释：342 + 465 = 807.

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
