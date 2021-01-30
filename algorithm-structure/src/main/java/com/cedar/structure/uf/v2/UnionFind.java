package com.cedar.structure.uf.v2;

import com.cedar.structure.uf.UF;

/**
 * @author zhangnan
 * @date 2021/1/29 17:48
 */
public class UnionFind implements UF {

    private int[] parent;

    public UnionFind(int size) {
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }


    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return false;
    }

    @Override
    public void unionElements(int p, int q) {

    }


    public int find(int p) {

        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }

        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}
