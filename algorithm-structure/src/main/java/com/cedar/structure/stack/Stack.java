package com.cedar.structure.stack;

/**
 * @author zhangnan
 * @date 2020-11-15 20:12
 */
public interface Stack<E> {

    /**
     * 入栈
     *
     * @param e
     */
    void push(E e);

    /**
     * 取栈顶元素
     *
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return
     */
    E peek();

    /**
     * 栈元素大小
     *
     * @return
     */
    int getSize();

    /**
     * 栈是否为空
     *
     * @return
     */
    boolean isEmpty();
}
