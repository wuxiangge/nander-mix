package com.cedar.recursion;

import java.util.Arrays;

public class Recursion {

    // 阶乘
    public int factorial(int n) {

        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }


    // 斐波那契
    public int fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    //全排列
    public <E> void perm(E[] list, int k, int m) {
        if (k == m) {
            System.out.println(Arrays.toString(list));
        } else {
            for (int i = k; i <= m; i++) {
                swap(list, k, i);
                perm(list, k + 1, m);
                swap(list, i, k);
            }
        }
    }


    //整数划分问题
    public int q(int n, int m) {
        if (n < 1 || m < 1) {
            return 0;
        }

        if (n == 1 || m == 1) {
            return 1;
        }

        if (n < m) {
            return q(n, n);
        }

        if (n == m) {
            return q(n, m - 1) + 1;
        }

        return q(n, m - 1) + q(n - m, m);
    }


    // 将A塔上数据移动到B塔 C作为辅助塔
    public void hanoi(int n, int a, int b, int c) {
        if (n > 0) {
            hanoi(n - 1, a, c, b);
//            move(a, b);  // 将A塔上编号为n的盘子移动到B塔上
            hanoi(n - 1, c, b, a);
        }

    }


    private <E> void swap(E[] list, int l, int r) {
        E temp = list[l];
        list[l] = list[r];
        list[r] = temp;
        temp = null;
    }


    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        recursion.factorial(10);
        recursion.fibonacci(10);

        Integer[] list = {1, 2, 3};
        recursion.perm(list, 0, 2);

        recursion.hanoi(3, 1, 1, 1);

    }


    /**
     * 两个矩阵乘机所需要的的计算量
     *
     * @param A
     * @param B
     * @param C
     * @param ARow
     * @param AColumn
     * @param BRow
     * @param BColumn
     */
    public void matrixMultiply(int[][] A, int[][] B, int[][] C, int ARow, int AColumn, int BRow, int BColumn) {

        if (AColumn != BRow) {
            throw new IllegalArgumentException("矩阵不可乘");
        }

        for (int i = 0; i < ARow; i++) {
            for (int j = 0; j < BColumn; j++) {
                int sum = A[i][0] * B[0][j];
                for (int k = 1; k < AColumn; k++) {
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }
    }

    public void matrixChain(int[] p, int n, int[][] m, int[][] s) {
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }
        for (int r = 2; r <= n; r++) {
            for (int i = 1; i <= n - r + 1; i++) {
                int j = i + r - 1;
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];

                s[i][j] = i;

                for (int k = i + 1; k < j; k++) {
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    public void traceBack(int i,int j ,int[][] s) {
        if (i==j) {
            return;
        }

        traceBack(i,s[i][j],s);
        traceBack(s[i][j]+1,j,s);

    }


}
