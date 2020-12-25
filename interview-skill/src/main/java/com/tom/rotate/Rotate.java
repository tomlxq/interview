package com.tom.rotate;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/2e95333fbdd4451395066957e24909cc?orderByHotValue=0&questionTypes=000100&mutiTagIds=639&page=1&onlyReference=false
 * 来源：牛客网
 *
 * [编程题]顺时针旋转矩阵
 * 热度指数：17816时间限制：C/C++ 3秒，其他语言6秒空间限制：C/C++ 32M，其他语言64M
 * 算法知识视频讲解
 * 有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。
 *
 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于300。
 *
 * 测试样例：
 * [[1,2,3],[4,5,6],[7,8,9]],3
 * 返回：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * @author TomLuo
 * @date 2020/3/5
 */
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.IntStream;
@Slf4j
public class Rotate {
    public int[][] rotateMatrix(int[][] mat, int n) {
        int temp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                temp[j][n-1-i]=mat[i][j];
            }
        }
        return temp;
    }
}