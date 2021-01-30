package com.cedar.structure.uf.v1;

import com.cedar.structure.uf.UF;

/**
 * @author zhangnan
 * @date 2021/1/29 17:38
 */
public class UnionFind implements UF {


    private int[] id;


    public UnionFind(int size) {
        this.id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }

    }


    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    @Override
    public void unionElements(int p, int q) {

        int pId = find(p);
        int qId = find(q);


        if (pId == qId) {
            return;
        }


        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }


    // 查找元素p 所对应的 集合编号
    private int find(int p) {

        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound");
        }

        return id[p];
    }


}
