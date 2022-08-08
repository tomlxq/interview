package com.tom.leetcode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BiteDome {

    public void bit() {
        int a = 0b01111;
        int b = 0b10000;
        /**
         * 异或运算
         * 相同为0，相异为1
         * 无进位相加
         */

        log.info("%s", Integer.toBinaryString(a ^ b));
    }

    /**
     * 一组数列，有1个数据出现过奇数次，基它出现过偶数次，请找出该数据
     *
     * @param ary
     * @return
     */
    public int printOddTimeNum(int[] ary) {
        int eor = 0;
        for (int i : ary) {
            eor ^= i;
        }
        return eor;
    }

    /**
     * 一组数列，有2个数据出现过奇数次，基它出现过偶数次，请找出该数据
     *
     * @param ary
     * @return
     */
    public int[] printOddTimeNum2(int[] ary) {
        int eor = 0;
        for (int i : ary) {
            eor ^= i;
        }
        //eor = a^b
        //eor!=0
        int rightOne = eor & (~eor + 1);//取出最右的1
        int onlyOne = 0;
        for (int i : ary) {
            if ((rightOne & i) == 0) {
                onlyOne ^= i;
            }
        }

        return new int[]{onlyOne, eor ^ onlyOne};
    }
}
