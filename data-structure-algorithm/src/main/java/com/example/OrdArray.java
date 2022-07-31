package com.example;

/**
 * 有序数组 二分查找
 */
public class OrdArray {
    /**
     * sort ary number
     */
    int nElement;
    long[] ary;

    public OrdArray(int size) {
        ary = new long[size - 1];
        nElement = 0;
    }

    public void display() {
        for (int i = 0; i < nElement; i++) {
            System.out.print(ary[i] + " ");
        }
        System.out.println();
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElement - 1;
        int curBound;
        while (true) {
            curBound = (lowerBound + upperBound) / 2;
            if (ary[curBound] == searchKey) {
                return curBound;
            } else if (lowerBound > upperBound) {
                return nElement;
            } else {
                //向后查找
                if (ary[curBound] < searchKey) {
                    lowerBound = curBound + 1;
                } else {
                    upperBound = curBound - 1;
                }
            }
        }
    }

    public void insert(long value) {
        int i;
        for (i = 0; i < nElement; i++) {
            if (ary[i] > value) {
                break;
            }
        }

        for (int j = nElement; j > i; j--) {
            //把前面一个移到后面
            ary[j] = ary[j - 1];
        }
        ary[i] = value;
        nElement++;
    }

    public boolean delete(long value) {
        int i = find(value);
        if (i == nElement) {
            return false;
        } else {
            for (int j = i; j < nElement; j++) {
                //将后面一个元素移到当前
                ary[j] = ary[j + 1];
            }
            nElement--;
            return true;
        }
    }

    public int size() {
        return nElement;
    }
}
