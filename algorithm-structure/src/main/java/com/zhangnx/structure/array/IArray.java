package com.zhangnx.structure.array;

public interface IArray<E> {

    public E get(int index);

    public void set(int index, E e);

    public boolean contains(E e);

    public int find(E e);

    public E remove(int index);

    public E getLast();

    public E getFirst();

    public E removeFirst();

    public E removeLast();

    public int getSize();

    public int getCapacity();

    public boolean isEmpty();

    public void addLast(E e);

    public void addFirst(E e);

    public void removeOneElement(E e);

    public void removeElement(E e);

    public void add(int index, E e);

    public void swap(int i, int j);


}
