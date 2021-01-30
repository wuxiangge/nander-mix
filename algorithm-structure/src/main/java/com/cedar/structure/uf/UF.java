package com.cedar.structure.uf;

/**
 * @author zhangnan
 * @date 2021/1/29 17:32
 */
public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);

}
