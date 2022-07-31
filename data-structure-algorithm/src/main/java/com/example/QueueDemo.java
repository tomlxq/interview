package com.example;

public class QueueDemo {
    private long[] data;
    private int rear;
    private int front;
    private int nElement;
    private int maxSize;

    public QueueDemo(int size) {
        data = new long[size];
        maxSize = size;
        rear = -1;
        front = 0;
    }

    public void insert(long value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        data[++rear] = value;
        nElement++;
    }

    public long remove() {
        if (front == maxSize) {
            front = 0;
        }
        long temp = data[front++];
        nElement--;
        return temp;
    }

    public boolean isEmpty() {
        return nElement == 0;
    }

    public boolean isFull() {
        return nElement == maxSize;
    }

    public long lookFront() {
        return data[front];
    }
}
