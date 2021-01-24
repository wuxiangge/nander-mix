package com.cedar.core;

/**
 * 位运算总结
 * <p>
 * 数字计算机中以反码的形式存储
 * 正数的原码等于反码
 * 怎么计算反码：
 * <p>
 * 11111111111111111111111111111011
 * 11111111111111111111111111111011    反码+1  得到补码
 * 11111111111111111111111111111010    反码   对源码按位取反（符号位不变）
 * 10000000000000000000000000000101    原码
 *
 * @author zhangnan
 * @date 2021/1/13 16:00
 */
public class BitOperation {

    public static void main(String[] args) {
//        int a = -17;
//        System.out.println("二进制输出"+Integer.toBinaryString(a));
//
//        System.out.println("八进制输出"+Integer.toOctalString(a));
//        System.out.printf("八进制输出"+"%010o\n",a);
//        //按10位十六进制输出，向右靠齐，左边用0补齐
//
//        System.out.printf("十六进制输出"+"%010x\n",a);
//        //按10位八进制输出，向右靠齐，左边用0补齐
//        System.out.println("十六进制输出"+Integer.toHexString(a));
//        System.out.println();
//
//
//        int b = 17;
//        System.out.println("二进制输出"+Integer.toBinaryString(b));
//
//        System.out.println("八进制输出"+Integer.toOctalString(b));
//        System.out.printf("八进制输出"+"%010o\n",b);
//
//        System.out.printf("十六进制输出"+"%010x\n",b);
//        System.out.println("十六进制输出"+Integer.toHexString(b));


//
//        int a = -5;
//        System.out.println(a);
//        System.out.println("二进制输出"+Integer.toBinaryString(a));
//        System.out.println(a+"<<2"+"="+(a<<2));
//        System.out.println("二进制输出"+Integer.toBinaryString(a<<2));
//        System.out.println(a+">>2"+"="+(a>>2));
//        System.out.println("二进制输出"+Integer.toBinaryString(a>>2));
//        System.out.println("无符号右移"+a+">>>2"+"="+(a>>>2));
//        System.out.println("二进制输出"+Integer.toBinaryString(a>>>2));
//        System.out.println();
//        int b = 5;
//        System.out.println(b);
//        System.out.println("二进制输出"+Integer.toBinaryString(b));
//        System.out.println(b+"<<2"+"="+(b<<2));
//        System.out.println("二进制输出"+Integer.toBinaryString(b<<2));
//        System.out.println(b+">>2"+"="+(b>>2));
//        System.out.println("二进制输出"+Integer.toBinaryString(b>>2));
//        System.out.println("无符号右移"+b+">>>2"+"="+(b>>>2));
//        System.out.println("二进制输出"+Integer.toBinaryString(b>>>2));


//        int a = 5;
//        System.out.println(Integer.toBinaryString(a));
//
//        int i = a & (0b001);
//        System.out.println(Integer.toBinaryString(i));
//
//        int j = a | (0b010);
//        System.out.println(Integer.toBinaryString(j));

        /**
         * 不引入第三个变量 交换两个数的值
         *
         * 　　异或是一种基于二进制的位运算，用符号XOR或者 ^ 表示，其运算法则是对运算符两侧数的每一个二进制位，同值取0，异值取1。
         *
         * 　　性质
         * 　　　　1、交换律
         * 　　　　2、结合律（即(a^b)^c == a^(b^c)）
         * 　　　　3、对于任何数x，都有x^x=0，x^0=x
         * 　　　　4、自反性 A XOR B XOR B = A XOR 0 = A
         *
         * A  ^ B  ^ B = A
         */
//
//        int a = 2;
//        int b = 3;
//
//        a = a ^ b;
//
//        b = a ^ b;
//
//        a = a ^ b;
//
//        System.out.println(a);
//        System.out.println(b);
//
//        int i = 1 ^ 2 ^ 3 ^ 4 ^ 3;
//        int j = 1 ^ 2 ^ 3 ^ 4 ;
//        System.out.println(i^j);

        int x = 5;

        System.out.println(Integer.toBinaryString(5));
        int i = ~x + 1;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(-5));


        /**
         *
         *
         * trimToSize
         * 101
         * ensureCapacity
         *
         * toArray
         *
         *
         *
         */


    }

}
