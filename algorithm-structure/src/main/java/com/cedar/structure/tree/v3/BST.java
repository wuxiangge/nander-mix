package com.cedar.structure.tree.v3;

public class BST<K extends Comparable<K>, V> {

    public class Node {

        public K key;

        public V value;

        public Node left, right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(K key, V value) {
            this(key, value, null, null);
        }

    }

    private Node root;

    private int size;

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
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
            return node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            return node.right = add(node.right, key, value);
        } else { // key.compareTo(node.key) = 0
            node.value = value;
            return node;
        }
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


    public V remove(K key) {
        Node node = remove(root, key);
        return node != null ? node.value : null;
    }


    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return node.left = remove(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return node.right = remove(node.right, key);
        } else { //key.compareTo(node.key) = 0
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {
                Node successor = minimum(node.right);
                successor.left = node.left;
                successor.right = remove(node, successor.key);
                node.left = node.right = null;
                return successor;
            }
        }
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

}
