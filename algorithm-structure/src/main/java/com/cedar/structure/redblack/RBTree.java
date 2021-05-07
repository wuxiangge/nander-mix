package com.cedar.structure.redblack;

/**
 * 红黑树的五个性质
 * 1.每个结点要么是红的要么是黑的。
 * <p>
 * 2.根结点是黑的。
 * <p>
 * 3.每个叶结点（叶结点即指树尾端NIL指针或NULL结点）都是黑的。
 * <p>
 * 4.如果一个结点是红的，那么它的两个儿子都是黑的。
 * <p>
 * 5.对于任意结点而言，其到叶结点树尾端NIL指针的每条路径都包含相同数目的黑结点。
 * *
 *
 * @param <K>
 * @param <V>
 */
public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;

    private static final boolean BLACK = false;

    public class Node {

        public K key;

        public V value;

        public Node left, right;

        public boolean color;

        public Node(K key, V value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }

        public Node(K key, V value) {
            this(key, value, null, null, RED);
        }
    }

    private Node root;

    private int size;

    public RBTree() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }


    private boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    public int getSize() {
        return size;
    }


    //              node                               x
    //              /  \                              /  \
    //             T1   x                           node  T3
    //                  / \                         /  \
    //                 T2  T3                      T1   T2
    //

    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    //                  node                                x
    //                  /  \                               /  \
    //                 x     T2                           y    node
    //                / \                                      / \
    //               y   T1                                   T1  T2

    private Node rightRotate(Node node) {
        Node x = node.left;

        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;
        return x;
    }


    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = node.right.color = BLACK;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = BLACK;
    }


    /**
     * 向以node为根的二分搜索树中添加键值对key value
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            ++size;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else { // key.compareTo(node.key) = 0
            node.value = value;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;

    }


    public boolean contains(K key) {
        Node node = getNode(root, key);
        return node != null;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node != null ? node.value : null;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException();
        }
        node.value = newValue;
    }

    public Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else { // key.compareTo(node.key) = 0
            return node;
        }
    }
}
