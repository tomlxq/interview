package com.tom.matrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/008759ec032e44c6b615f7b6a5b752aa?orderByHotValue=0&questionTypes=000100&mutiTagIds=639&page=1&onlyReference=false
 * 来源：牛客网
 *
 * 您的代码已保存
 * 答案错误:您提交的程序没有通过所有的测试用例
 * case通过率为10.00%
 *
 * 用例:
 * [[0,1,0,0],[1,0,0,0],[0,0,1,1],[0,1,0,1]],4
 *
 * 对应输出应该为:
 *
 * 2
 *
 * 你的输出为:
 *
 * -1
 *
 * @author TomLuo
 * @date 2020/3/7
 */
public class SubMatrixTest {

    @Test
    public void maxSubMatrix() {
        //  * [[1,1,1],[1,0,1],[1,1,1]],3
        //* 返回：3
        int mat[][] = new int[3][3];
        mat[0] = new int[]{1, 1, 1};
        mat[1] = new int[]{1, 0, 1};
        mat[2] = new int[]{1, 1, 1};
        SubMatrix s = new SubMatrix();
        assertEquals(s.maxSubMatrix(mat, 3), 3);
        int mat1[][] = new int[4][4];
        mat1[0] = new int[]{0,1,0,0};
        mat1[1] = new int[]{1,0,0,0};
        mat1[2] = new int[]{0,0,1,1};
        mat1[3] = new int[]{0,1,0,1};
        assertEquals(s.maxSubMatrix(mat1, 4), 2);
        //[[0,1,0,0],[1,0,0,0],[0,0,1,1],[0,1,0,1]],4
    }
}