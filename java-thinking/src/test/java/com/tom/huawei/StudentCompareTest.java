package com.tom.huawei;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentCompareTest {
    StudentCompare sc = null;

    @Before
    public void setUp() throws Exception {
        sc = new StudentCompare();
    }

    /**
     * 1.【寻找身高相近的小朋友】
     * 【寻找身高相近的小朋友】小明今年升学到小学一年级，来到新班级后发现其他小朋友们身高参差不齐，然后就想基于各小朋友和自己的身高差对他们进行排序，请帮他实现排序。
     * <p>
     * 输入描述：
     * <p>
     * 第一行为正整数H和N，0<H<200，为小明的身高，0<N<50，为新班级其他小朋友个数。第第二行为N个正整数H1-HN，分别是其他小朋友的身高，取值范围0<N<50，为新班级其他小朋友个数。  第二行为N个正整数H1-HN，分别是其他小朋友的身高，取值范围0><Hi<200（1<=i<=N），且N个正整数各不相同。
     * <p>
     * 输出描述：
     * <p>
     * 输出排序结果，各正整数以空格分割。和小明身高差绝对值最小的小朋友排在前面，和小明身高差绝对值最大的小朋友排在最后，如果两个小朋友和小明身高差一样，则个子较小的小朋友排在前面。
     * <p>
     * 示例1：
     * <p>
     * 输入
     * <p>
     * 100 10
     * <p>
     * 95 96 97 98 99101 102 103 104 105
     * <p>
     * 输出
     * <p>
     * 99 101 98 102 97103 96 104 95 105
     * ————————————————
     * 版权声明：本文为CSDN博主「@_南先森」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/nanzhanfei/article/details/124895671
     */
    @Test
    public void compareStudent() {
        assertEquals("99 101 98 102 97 103 96 104 95 105", sc.compareStudent2("100 10", "95 96 97 98 99 101 102 103 104 105"));
        assertEquals("99 101 98 102 97 103 96 104 95 105", sc.compareStudent("100 10", "95 96 97 98 99 101 102 103 104 105"));
        assertEquals("99 101 98 102 97 103 96 104 95 105", sc.compareStudent3("100 10", "95 96 97 98 99 101 102 103 104 105"));
    }

}