package com.cedar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 数据结构
 *
 * @author zhangnan
 * @date 2021/8/5
 */
public class Structure {

    // 数组数据结构
    public static class Array<E extends Comparable<? super E>> {

        private E[] data;

        private int size;

        public Array() {
            this(10);
        }

        public Array(int capacity) {
            data = (E[]) new Object[capacity];
            size = 0;
        }

        public Array(E[] arr) {
            data = (E[]) new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            size = arr.length;
        }

        public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("参数异常");
            }
            return data[index];
        }

        public void set(int index, E e) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("参数异常");
            }
            data[index] = e;
        }

        public boolean contains(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    return true;
                }
            }
            return false;
        }

        public int find(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    return i;
                }
            }
            return -1;
        }

        public E remove(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("参数异常");
            }
            E ret = data[index];
            for (int i = index + 1; i < size; i++) {
                data[i - 1] = data[i];
            }
            size--;

            if (size == data.length / 4 && data.length / 2 != 0) {
                resize(data.length / 2);
            }
            return ret;
        }

        public E getLast() {
            return get(size - 1);
        }

        public E getFirst() {
            return get(0);
        }

        public E removeFirst() {
            return remove(0);
        }

        public E removeLast() {
            return remove(size - 1);
        }

        public int getSize() {
            return size;
        }

        public int getCapacity() {
            return data.length;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void addLast(E e) {
            add(size, e);
        }

        public void addFirst(E e) {
            add(0, e);
        }

        public void removeOneElement(E e) {
            int i = find(e);
            if (i != -1) {
                remove(i);
            }
        }

        public void removeElement(E e) {
            for (int i = 0; i < size; i++) {
                if (data[i] == e) {
                    remove(i);
                }
            }
        }

        public void add(int index, E e) {
            if (size >= data.length) {
                resize(2 * data.length);
            }
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("参数异常");
            }

            for (int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }

            data[index] = e;
            size++;
        }

        private void resize(int capacity) {
            E[] newData = (E[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }

        public void swap(int i, int j) {
            if (i < 0 || i >= size || j < 0 || j >= size) {
                throw new IllegalArgumentException("index is illegal");
            }

            E t = data[i];
            data[i] = data[j];
            data[j] = t;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
            stringBuilder.append("[");
            for (int i = 0; i < size; i++) {
                stringBuilder.append(data[i]);
                if (i != size - 1) {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    // avlTree
    public static class AVLTree<K extends Comparable<? super K>, V> {

        private class Node {
            private K key;
            private V value;
            private Node left, right;
            private int height;

            public Node(K key, V value) {
                this(key, value, null, null, 1);
            }

            public Node(K key, V value, Node left, Node right, int height) {
                this.key = key;
                this.value = value;
                this.left = left;
                this.right = right;
                this.height = height;
            }
        }

        private Node root;
        private int size;

        public AVLTree() {
            this(null, 0);
        }

        public AVLTree(Node root, int size) {
            this.root = root;
            this.size = size;
        }

        /**
         * 获取Avl树的高度
         *
         * @param node
         * @return
         */
        public int getHeight(Node node) {
            if (node == null) {
                return 0;
            }
            return node.height;
        }

        public boolean isEmpty() {
            return getSize() == 0;
        }

        public int getSize() {
            return size;
        }

        public void add(K key, V value) {
            root = add(root, key, value);
        }

        public Node add(Node node, K key, V value) {
            if (node == null) {
                size++;
                return new Node(key, value);
            }

            if (key.compareTo(node.key) < 0) {
                node.left = add(node.left, key, value);
            } else if (key.compareTo(node.key) > 0) {
                node.right = add(node.right, key, value);
            } else {
                node.value = value;
            }

            // 重新计算节点高度
            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

            int balanceFactor = getBalanceFactor(node);
            if (Math.abs(balanceFactor) > 1) {
                System.out.println("-------->unbalanced : " + balanceFactor);
            }
            // avl 维护自平衡 左旋 右旋
            if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
                // 右旋转  LL
                return rightRotate(node);
            }
            if (balanceFactor < -1 && getHeight(node.right) <= 0) {
                // 左旋转 RR
                return leftRotate(node);
            }
            //LR    LR--->LL
            if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
            //RL
            if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
            return node;


        }


        // 右旋转
        //
        //                      y                             x
        //                     / \                           /  \
        //                   x    T4                       z      y
        //                  / \                           / \    / \
        //                 z   T3                       T1  T2  T3  T4
        //                / \
        //              T1   T2
        private Node rightRotate(Node y) {
            Node x = y.left;
            Node T3 = x.right;
            x.right = y;
            y.left = T3;

            //更新height
            y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
            x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
            return x;
        }


        // 左旋转
        //
        //                      y                             x
        //                     / \                           /  \
        //                   T1   x                         y    z
        //                       / \                      / \    / \
        //                      T2  z                    T1  T2  T3  T4
        //                         / \
        //                        T3  T4
        private Node leftRotate(Node y) {
            Node x = y.right;
            Node T2 = x.left;

            x.left = y;
            y.right = T2;

            //更新height
            y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
            x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
            return x;
        }


        public boolean isBST() {
            List<K> keys = new ArrayList<>();
            inOrder(root, keys);
            return IntStream.range(1, keys.size()).noneMatch(i -> keys.get(i - 1).compareTo(keys.get(i)) > 0);
        }

        public boolean isBalance() {
            return isBalance(root);
        }

        private boolean isBalance(Node node) {
            if (node == null) {
                return true;
            }

            int balanceFactor = getBalanceFactor(node);
            if (Math.abs(balanceFactor) > 1) {
                return false;
            }
            return isBalance(node.left) && isBalance(node.right);
        }

        /**
         * 中序遍历的性质
         * <p>
         * <p>
         * 中序遍历的性质 从小到大排序
         *
         * @param node
         * @param keys
         */
        private void inOrder(Node node, List<K> keys) {
            if (node == null) {
                return;
            }
            inOrder(node.left, keys);
            keys.add(node.key);
            inOrder(node.right, keys);
        }


        private int getBalanceFactor(Node node) {
            return getHeight(node.left) - getHeight(node.right);
        }

        public boolean contains(K key) {
            Node node = getNode(root, key);
            return node != null;
        }

        public V get(K key) {
            Node node = getNode(root, key);
            return node == null ? null : node.value;
        }

        public void set(K key, V newValue) {
            Node node = getNode(root, key);
            if (node == null) {
                throw new IllegalArgumentException();
            }
            node.value = newValue;
        }

        private Node getNode(Node node, K key) {
            if (node == null) {
                return null;
            }
            if (key.compareTo(node.key) < 0) {
                return getNode(node.left, key);
            } else if (key.compareTo(node.key) > 0) {
                return getNode(node.right, key);
            } else {
                return node;
            }
        }

        public Node maximum() {
            return maximum(root);
        }

        private Node maximum(Node node) {
            if (node.right == null) {
                return node;
            }
            return maximum(node.right);
        }

        public Node minimum() {
            return minimum(root);
        }

        private Node minimum(Node node) {
            if (node.left == null) {
                return node;
            }
            return minimum(node.left);
        }

        public V remove(K key) {
            Node node = remove(root, key);
            return node == null ? null : node.value;
        }


        /**
         * 返回node中的key节点
         *
         * @param node
         * @param key
         * @return
         */
        private Node remove(Node node, K key) {
            if (node == null) {
                return null;
            }

            Node retNode;
            if (key.compareTo(node.key) < 0) {
                node.left = remove(node.left, key);
                retNode = node;
            } else if (key.compareTo(node.key) > 0) {
                node.right = remove(node.right, key);
                retNode = node;
            } else { // 开始处理 key.compareTo(node.key)=0
                if (node.right == null) {
                    Node leftNode = node.left;
                    node.left = null;
                    size--;
                    retNode = leftNode;
                } else if (node.left == null) {
                    Node rightNode = node.right;
                    node.right = null;
                    size--;
                    retNode = rightNode;
                } else {
                    Node successor = minimum(node.right);
                    successor.right = remove(node.right, successor.key);
                    successor.left = node.left;
                    node.left = node.right = null;
                    retNode = successor;
                }
            }

            if (retNode == null) {
                return null;
            }
            // 重新计算节点高度
            retNode.height = Math.max(getHeight(retNode.left), getHeight(retNode.right)) + 1;

            int balanceFactor = getBalanceFactor(retNode);
            if (Math.abs(balanceFactor) > 1) {
                System.out.println("-------->unbalanced : " + balanceFactor);
            }

            // avl 维护自平衡 左旋 右旋
            if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
                // 右旋转  LL
                return rightRotate(retNode);
            }

            if (balanceFactor < -1 && getHeight(retNode.right) <= 0) {
                // 左旋转 RR
                return leftRotate(retNode);
            }

            //LR    LR--->LL
            if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
                retNode.left = leftRotate(retNode.left);
                return rightRotate(retNode);
            }

            //RL
            if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
                retNode.right = rightRotate(retNode.right);
                return leftRotate(retNode);
            }
            return retNode;
        }
    }

    // 最大堆
    public static class MaxHeap<E extends Comparable<? super E>> {
        //用来存放数据
        private List<E> arrayList;

        public MaxHeap() {
            this.arrayList = new ArrayList<>();
        }

        public MaxHeap(E[] data) {
            heapify(data);
        }

        private void heapify(E[] data) {
            arrayList = new ArrayList<>();
            arrayList.addAll(Arrays.asList(data));
            for (int i = parent(data.length - 1); i >= 0; i--)
                siftDown(i, arrayList);
        }

        private int parent(int k) {
            if (k == 0) throw new IllegalArgumentException();
            return (k - 1) / 2;
        }

        private int leftChild(int k) {
            return 2 * k + 1;
        }


        private void siftDown(int index, List<E> data) {
            while (leftChild(index) < data.size()) {
                int j = leftChild(index); // 定义子树中较大的那一个
                if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                    j = j + 1;
                }
                if (data.get(index).compareTo(data.get(j)) > 0) {
                    break;
                }
                swap(data, index, j);
                index = j;
            }
        }

        private void swap(List<E> data, int l, int r) {
            E temp = data.get(l);
            data.set(l, data.get(r));
            data.set(r, temp);
            temp = null;
        }

    }

    // 链表
    public static class LinkList<E> {

    }


}
