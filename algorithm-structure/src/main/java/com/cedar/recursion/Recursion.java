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

    public void traceBack(int i, int j, int[][] s) {
        if (i == j) {
            return;
        }

        traceBack(i, s[i][j], s);
        traceBack(s[i][j] + 1, j, s);

    }


    /**
     * 动态规划计算最长公共子序列
     */
    public void LCSLength(int m, int n, char[] x, char[] y, int[][] c, int[][] b) {
        int i, j;

        for (i = 1; i <= m; i++) {
            c[i][0] = 0;
        }

        for (i = 1; i <= n; i++) {
            c[0][i] = 0;
        }

        for (i = 1; i <= m; i++) {
            for (j = i; j <= n; j++) {
                if (x[i] == y[j]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 2;
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 3;
                }
            }
        }
    }


    /**
     * 最大字段和 分治法
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    public int maxSubSum(int[] a, int left, int right) {


        int sum = 0;
        if (left == right) {
            return Math.max(a[left], 0);
        }

        int middle = left + (right - left) / 2;

        int leftSum = maxSubSum(a, left, middle);
        int rightSum = maxSubSum(a, middle + 1, right);


        int s1 = 0;
        int lefts = 0;

        for (int i = middle; i >= left; i--) {
            lefts += a[i];
            if (lefts > s1) {
                s1 = lefts;
            }
        }
        int s2 = 0;
        int rights = 0;

        for (int i = middle + 1; i <= right; i++) {
            rights += a[i];
            if (rights > s2) {
                s2 = rights;
            }
        }
        sum = s1 + s2;
        if (sum < leftSum) {
            sum = leftSum;
        }
        if (sum < rightSum) {
            sum = rightSum;
        }
        return sum;
    }


    /**
     * 简单字串搜索算法
     *
     * @param t
     * @param p
     * @return
     */
    int naive(String t, String p) {
        int n = t.length();
        int m = p.length();

        int i = 0;
        while (i < n - m) {
            int j = 0;

            while (j < m && t.charAt(i + j) == p.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i;
            }
            i++;
        }
        return -1;
    }


    /**
     * 寻找最大前缀串使其也是一个后缀
     * next(q) = max{k|p[0...k] =|p[0...q]}
     *
     * @param p
     * @param next
     */
    private void build(String p, int[] next) {
        int m = p.length();
        next[0] = -1;
        int j = -1;

        for (int i = 1; i < m - 1; i++) {
            while (j > -1 && p.charAt(j + 1) != p.charAt(i)) {
                j = next[j];
            }

            if (p.charAt(j + 1) == p.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }


    int kmp(String t, String p) {
        int n = t.length();
        int m = p.length();
        int[] next = new int[m];
        build(p, next);

        int j = -1;
        for (int i = 0; i < n; i++) {
            while (j > -1 && p.charAt(j + 1) != t.charAt(i)) {
                j = next[j];
            }
            if (p.charAt(j + 1) == t.charAt(i)) {
                j++;
            }
            if (j == m - 1) {
                return i - m + 1;
            }
        }
        return -1;
    }


}
