package com.cedar.structure.tree.v2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary search tree 二分搜索树
 *
 * @author zhangnan
 * @date 2021/1/19 13:57
 */
public class BST<E extends Comparable<? super E>> {

    private class Node {

        public E e;

        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;

    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public void add(E e) {
        root = add(root, e);
    }


    /**
     * 向以node为根的二分搜索树中插入元素e,递归算法
     * 返回插入新结算后二分搜索树的根
     */
    public Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }


    // 二分搜索树前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 二分搜索中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        preOrder(node.left);
        System.out.println(node.e);
        preOrder(node.right);
    }


    // 二分搜索树后序遍历
    public void postOrder() {
        preOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }


    // 二分搜索树非递归操作 使用栈数据结构
    // 使用栈前序遍历 栈和递归的等价性
    public void preOrderNR() {
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }


    // 层序遍历 使用队列
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


    // 寻找二分搜索树的最小元素
    public E minimun() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }

        return minimun(root).e;
    }

    private Node minimun(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimun(node.left);
    }


    // 寻找二分搜索树的最大元素
    public E maximun() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }

        return maximun(root).e;
    }

    private Node maximun(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximun(node.right);
    }


    public E removeMin() {
        E ret = minimun();
        root = removeMin(root);
        return ret;
    }

    // 返回删除最小元素后的node节点
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }


    public E removeMax() {
        E ret = maximun();
        root = removeMax(root);
        return ret;
    }

    // 返回删除最小元素后的node节点
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node rightNode = node.left;
            node.left = null;
            size--;
            return rightNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    //宏观语义 返回删除e元素后的node节点
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {// if (e.compareTo(node.e) == 0)
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 左右子树都不为空
            Node successor = minimun(node.right); // 查找右子树中最小的元素 前驱后继节点
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }


}
