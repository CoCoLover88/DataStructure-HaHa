package com.company.sparsearray;

import org.junit.Test;

public class SparseArray {
    /*数组压缩成稀疏矩阵*/
    @Test
    public void compress() {
        /*
        创建一个原始的二维数组11*11
        0表示没有棋子，1表示黑子，2表示蓝子
         */
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        /*输出原有数组*/
        System.out.println("二维数组：");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        /*对数组进行压缩*/
        int sum = 0; //有效数据个数
        for (int[] row : chessArr) {
            for (int data : row) {
                if (data != 0) {
                    sum += 1;
                }
            }
        }

        /*创建稀疏矩阵*/
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = sum;
        int row = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                if (chessArr[i][j] != 0) {
                    row++;
                    sparseArr[row][0] = i;
                    sparseArr[row][1] = j;
                    sparseArr[row][2] = chessArr[i][j];
                }
            }
        }

        /*输出稀疏数组*/
        System.out.println("稀疏数组：");
        for (int[] row2 : sparseArr) {
            for (int data : row2) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        /*将稀疏矩阵转为二维数组*/
        int chessArr02[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr02[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("稀疏数组转二维数组：");
        for (int[] row3 : chessArr02) {
            for (int data : row3) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }


}
