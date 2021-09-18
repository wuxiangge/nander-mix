package com.cedar.structure.uf.v3;

import com.cedar.structure.uf.UF;

/**
 * @author zhangnan
 * @date 2021/9/7
 */
public class UnionFind implements UF {

    private int count;
    private int[] parent;
    private int[] size;


    public UnionFind(int count) {
        this.count = count;
        parent = new int[count];
        size = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return this.count;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        // 小数接到大树下面比较平衡
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }


    /**
     * 返回某个节点的根节点
     *
     * @param n
     * @return
     */
    private int find(int n) {
        while (n != parent[n]) {
            // 路径压缩
            parent[n] = parent[parent[n]];
            n = parent[n];
        }
        return n;
    }
}
