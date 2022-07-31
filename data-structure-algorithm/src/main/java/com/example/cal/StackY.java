package com.example.cal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StackY {
    private int[] data;
    private int maxSize;
    private int top;

    public StackY(int size) {
        this.maxSize = size;
        data = new int[maxSize];
        top = -1;
    }

    public void push(int c) {
        this.data[++top] = c;
    }

    public int pop() {
        return data[top--];
    }

    public int peek() {
        return data[top];
    }

    public int peekN(int n) {
        return data[n];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void display(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(peekN(i) + " ");
        }
        System.out.println();
    }
}
