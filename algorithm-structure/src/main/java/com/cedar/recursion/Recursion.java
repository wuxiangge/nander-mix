package com.cedar.recursion;

import com.sun.image.codec.jpeg.JPEGCodec;

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

        recursion.hanoi(3,1,1,1);

    }


}
