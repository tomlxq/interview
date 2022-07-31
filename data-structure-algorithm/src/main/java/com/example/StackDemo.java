package com.example;

public class StackDemo {
    private long[] data;
    private int top;

    public StackDemo(int maxSize) {
        data = new long[maxSize];
        top = -1;
    }

    public void push(long value) {
        data[++top] = value;
    }

    public long pop() {
        return data[top--];
    }

    public long peek() {
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

}
