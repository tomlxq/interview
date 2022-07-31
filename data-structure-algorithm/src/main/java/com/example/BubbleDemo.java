package com.example;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Slf4j
public class BubbleDemo {
    private String[] ary;
    private int nElement;

    public BubbleDemo(int max) {
        ary = new String[max];
        nElement = 0;
    }

    public void insert(String str) {
        ary[nElement] = str;
        nElement++;
    }

    /**
     * 冒泡排序
     * 两两比较 如果小就交换顺序
     * 第一轮下来，将最小的排序最后，再缩小范围
     */
    public void order() {
        for (int i = nElement - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (ary[j].compareTo(ary[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public void orderSel() {
        int i, j, min;
        for (i = 0; i < nElement; i++) {
            min = i;
            for (j = i + 1; j < nElement; j++) {
                if (ary[j].compareTo(ary[min]) < 0) {
                    min = j;
                }
            }
            swap(i, min);
        }
    }

    public void orderInsert() {
        int out, in;
        for (out = 1; out < nElement; out++) {
            //把当前位置空出来,
            String tmp = ary[out];
            in = out;
            while (in > 0 && ary[in - 1].compareTo(tmp) > 0) {
                ary[in] = ary[in - 1];
                in--;
            }
            ary[in] = tmp;
        }
    }

    public String display() {
        String str = IntStream.range(0, nElement).boxed().map(idx -> ary[idx]).collect(Collectors.joining(","));
        log.info("order is: {}", str);
        return str;
    }

    private void swap(int j, int i) {
        String temp = ary[j];
        ary[j] = ary[i];
        ary[i] = temp;
    }
}
