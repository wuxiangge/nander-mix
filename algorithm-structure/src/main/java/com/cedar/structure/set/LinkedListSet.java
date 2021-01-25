package com.cedar.structure.set;

import com.cedar.structure.list.LinkedList;

/**
 * @author zhangnan
 * @date 2021/1/25 16:41
 */
public class LinkedListSet<E> implements Set<E> {


    private LinkedList<E> list;


    public LinkedListSet() {
        this.list = new LinkedList<>();
    }


    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFist(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
