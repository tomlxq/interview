package com.example.cal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StackX {
    private char[] data;
    private int maxSize;
    private int top;

    public StackX(int size) {
        this.maxSize = size;
        data = new char[maxSize];
        top = -1;
    }

    public void push(char c) {
        this.data[++top] = c;
    }

    public char pop() {
        return data[top--];
    }

    public char peek() {
        return data[top];
    }

    public char peekN(int n) {
        return data[n];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
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
