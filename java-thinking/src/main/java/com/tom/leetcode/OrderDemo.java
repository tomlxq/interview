package com.tom.leetcode;

public class OrderDemo {
    public void selectSort(int[] ary) {
        if (ary == null || ary.length == 0) {
            return;
        }
        for (int i = 0; i < ary.length; i++) {
            int minIdx = i;
            //0-N中查找小值的下标
            for (int j = i + 1; j < ary.length; j++) {
                minIdx = ary[j] < ary[minIdx] ? j : minIdx;
            }
            swap(ary, minIdx, i);
        }
    }

    public void bubbleSort(int[] ary) {
        if (ary == null || ary.length == 0) {
            return;
        }
        //第一个For循环规定在那一轮上两两交换
        for (int i = ary.length - 1; i > 0; i--) {
            //最大的放最后
            for (int j = 0; j < i; j++) {
                if (ary[j] > ary[j + 1]) {
                    swap(ary, j, j + 1);
                }
            }
        }
    }

    public void insertSort(int[] ary) {
        if (ary == null || ary.length == 0) {
            return;
        }
        //0~0 天然排好序
        //要看 0~i 想排好序
        for (int i = 1; i < ary.length; i++) {
            for (int j = i - 1; j >= 0 && ary[j] > ary[j + 1]; j--) {
                swap(ary, j, j + 1);
            }
        }
    }

    public void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] ^ data[j];
        data[j] = data[i] ^ data[j];
        data[i] = data[i] ^ data[j];
    }

}
