package com.cedar.structure.set;

/**
 * @author zhangnan
 * @date 2021/1/19 16:23
 */
public interface Set<E> {


    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
