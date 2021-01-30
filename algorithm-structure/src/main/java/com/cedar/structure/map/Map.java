package com.cedar.structure.map;

/**
 * @author zhangnan
 * @date 2021/1/25 16:53
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();
}
