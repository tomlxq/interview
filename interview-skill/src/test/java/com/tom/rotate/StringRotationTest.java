package com.tom.rotate;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/7
 */
public class StringRotationTest {
    @Test
    public void name() {
         //* "ABCDEFGH",8,4
         //       * 返回："FGHABCDE"
                StringRotation sr=new StringRotation();
        Assert.assertEquals("FGHABCDE",sr.rotateString("ABCDEFGH",8,4));
        Assert.assertEquals("FGHABCDE",sr.rotateString1("ABCDEFGH",8,4));
        Assert.assertEquals("QQPQWIVL",sr.rotateString1("PQWIVLQQ",8,5));

        //"PQWIVLQQ",8,5
    }
}