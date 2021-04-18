package com.cedar.sparsearray;

/**
 * 稀疏数组
 *
 * @author zhangnan
 * @date 2021-04-18 17:49
 */
public class SparseArray {

    public static void main(String[] args) {

        int[][] chessArrOld = new int[11][11];

        chessArrOld[1][2] = 1;
        chessArrOld[2][3] = 2;

        for (int[] row : chessArrOld) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int sum = 0;

        for (int[] row : chessArrOld) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }

        System.out.println(sum);

        int row = chessArrOld.length;
        int column = chessArrOld[0].length;

        /**
         * 11 11 2
         * 1  2  1
         * 2  3  2
         *
         *
         */

        int[][] compressArray = new int[sum + 1][3];
        compressArray[0][0] = row;
        compressArray[0][1] = column;
        compressArray[0][2] = sum;


        int count = 0; //count 用于记录是第几个非0 数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArrOld[i][j] != 0) {
                    count++;
                    compressArray[count][0] = i;
                    compressArray[count][1] = j;
                    compressArray[count][2] = chessArrOld[i][j];
                }
            }
        }

        // 输出稀疏数组的形式
        System.out.println();
        System.out.println("得到稀疏数组为~~~~");
        for (int i = 0; i < compressArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", compressArray[i][0], compressArray[i][1], compressArray[i][2]);
        }
        System.out.println();


        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int chessArr2[][] = new int[compressArray[0][0]][compressArray[0][1]];
        //2. 在读取稀疏数组后几行的数据(从第二行开始)，并赋给原始的二维数组即可
        for (int i = 1; i < compressArray.length; i++) {
            chessArr2[compressArray[i][0]][compressArray[i][1]] = compressArray[i][2];
        }
        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");
        for (int[] rowArray : chessArr2) {
            for (int data : rowArray) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }


}
