package com.cedar.structure.set;

import com.cedar.structure.tree.v2.BST;

/**
 * @author zhangnan
 * @date 2021/1/19 16:25
 */
public class BSTSet<E extends Comparable<? super E>> implements Set<E> {


    private BST<E> bst;


    public BSTSet() {
        this.bst = new BST<>();
    }


    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }


}
