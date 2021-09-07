package com.cedar.structure.uf;

/**
 * @author zhangnan
 * @date 2021/1/29 17:48
 */
public class UnionFind implements UF {

    private int size;

    private int[] parent;

    public UnionFind(int size) {
        this.size = size;
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }


    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        parent[pRoot] = qRoot;
        size--;
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
