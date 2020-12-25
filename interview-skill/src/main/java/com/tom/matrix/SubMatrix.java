package com.tom.matrix;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/008759ec032e44c6b615f7b6a5b752aa?orderByHotValue=0&questionTypes=000100&mutiTagIds=639&page=1&onlyReference=false
 * 来源：牛客网
 * <p>
 * 有一个方阵，其中每个单元(像素)非黑即白(非0即1)，请设计一个高效算法，找到四条边颜色相同的最大子方阵。
 * <p>
 * 给定一个01方阵mat，同时给定方阵的边长n，请返回最大子方阵的边长。保证方阵边长小于等于100。
 * <p>
 * 测试样例：
 * [[1,1,1],[1,0,1],[1,1,1]],3
 * 返回：3
 *
 * @author TomLuo
 * @date 2020/3/7
 */
@Slf4j
public class SubMatrix {
    public int maxSubMatrix(int[][] mat, int n) {
        // write code here
        //第一条边 0,0 1,0 ...n-1,0
        //第二条边 n-1,0 n-1,1 ..n-1,n-1
        //第三条边 0,n-1 1,n-1 .. n-1,n-1
        //第四条边 0,0 0,1 0,n-1
        int maxDot = n;
        while (maxDot > 1) {
            log.info("{}",maxDot);
            int sum=0;
            int init=0;
            for(int i=init;i<maxDot;i++){
                sum+=mat[i][init];
                sum+=mat[i][maxDot-1];
                sum+=mat[init][i];
                sum+=mat[maxDot-1][i];
            }
            if(sum==0||sum==4*maxDot){
                return maxDot;
            }
            init++;
            maxDot--;

        }
        return -1;
    }
}
