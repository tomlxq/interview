package com.tom.print;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/7df39c7556424eada267d8f793961a1e?orderByHotValue=0&questionTypes=000100&mutiTagIds=639&page=1&onlyReference=false
 * 来源：牛客网
 * <p>
 * 对于一个矩阵，请设计一个算法，将元素按“之”字形打印。具体见样例。
 * <p>
 * 给定一个整数矩阵mat，以及他的维数nxm，请返回一个数组，其中元素依次为打印的数字。
 * <p>
 * 测试样例：
 * [[1,2,3],[4,5,6],[7,8,9],[10,11,12]],4,3
 * 返回：[1,2,3,6,5,4,7,8,9,12,11,10]
 */
public class Printer {
    public int[] printMatrix(int[][] mat, int n, int m) {
        //返回1维数组
        int[] tmp = new int[n * m];
        //记录个数
        int count = 0;
        int row=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row % 2 == 0) {
                    tmp[count++] = mat[i][m-j-1];
                } else {
                    tmp[count++] = mat[i][j];
                }
            }
            row++;
        }
        return tmp;
    }
}