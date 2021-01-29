package com.cedar.structure.segmenttree;

/**
 * @author zhangnan
 * @date 2021/1/28 20:10
 */
public interface Merger<E> {

    E merge(E a, E b);
}
