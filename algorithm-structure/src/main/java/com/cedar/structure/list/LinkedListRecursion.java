package com.cedar.structure.list;

/**
 * 递归处理链表
 *
 * @param <E>
 */
public class LinkedListRecursion<E> {

    public class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }


        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


    private Node head;

    private int size;


    public LinkedListRecursion() {
        head = null;
        size = 0;
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        head = add(head, index, e);
        size++;
    }


    private Node add(Node node, int index, E e) {
        if (index == 0) {
            return new Node(e, node);
        }

        node.next = add(node, index - 1, e);
        return node;
    }


}
