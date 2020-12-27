package offer.q30;

/**
 * 他出一个 LinkList 加一个 PriorityQueue 当时我刚大E没有闪 年轻人不讲武德
 * 他也说自己年轻不懂规矩 如果点到为止的话是我赢
 *
 * @author zhangnan
 * @date 2020-11-15 22:07
 */
class MinStack {

    private Node<Integer> head;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int x) {

        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(head.minValue, x), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int min() {
        return head.minValue;
    }

    private class Node<E> {
        private E value;
        private E minValue;
        private Node next;

        public Node(E value, E minValue, Node next) {
            this.value = value;
            this.minValue = minValue;
            this.next = next;
        }
    }
}
