package com.example;

public class StackCharDemo {
    private char[] data;
    private int top;

    public StackCharDemo(int maxSize) {
        data = new char[maxSize];
        top = -1;
    }

    public void push(char value) {
        data[++top] = value;
    }

    public char pop() {
        return data[top--];
    }

    public char peek() {
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

}
