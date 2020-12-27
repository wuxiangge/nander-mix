package offer.q09;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 两个栈实现一个队列
 * 栈后进先出
 * 队列 先进先出
 * <p>
 * 所有元素都是栈 1 入栈
 * 所有元素都是栈 2 出栈
 * 在栈1 排队 后进先出 在栈2排队先进后出 最终表现为先进先出
 * 涉及到两个栈之间的元素迁移 使用非线性表 作为底层实现
 *
 * @author zhangnan
 * @date 2020-11-15 21:35
 */
public class CQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList();
        stack2 = new LinkedList();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1;
            }
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
