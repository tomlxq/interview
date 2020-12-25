package com.tom.rotate;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/5
 */
@Slf4j
public class RotateTest {

    @Test
    public void rotateMatrix() {
        Rotate rotate = new Rotate();
        List<Integer> targets=Arrays.asList(7,4,1,8,5,2,9,6,3);
        int[][] tarAry = new int[3][3];
        int[][] mat = new int[3][3];
        int k=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                tarAry[i][j]=targets.get(k);
                mat[i][j]=k+1;
                k++;
            }
        }
         int[][] s=rotate.rotateMatrix(mat,3);
        Assert.assertArrayEquals(tarAry,s);

    }
}