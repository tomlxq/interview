package com.example;

public class PriorityQueueDemo {
    private long[] data;
    private int maxSize;
    private int nElement;

    public PriorityQueueDemo(int size) {
        data = new long[size];
        nElement = 0;
        maxSize = size;
    }

    public void insert(long value) {
        //no elements,just put to first pos
        if (nElement == 0) {
            data[nElement++] = value;
            return;
        }
        //insert pos
        int i;
        for (i = nElement - 1; i >= 0; i--) {
            //if value is more than any data, move the current value to the next one
            if (data[i] < value) {
                data[i + 1] = data[i];
            } else {
                //means find the position, terminate the loop
                break;
            }
        }
        //the next one equal the value
        data[i + 1] = value;
        nElement++;
    }

    public long remove() {
        return data[--nElement];
    }

    public long peekMin() {
        return data[nElement - 1];
    }

    public boolean isEmpty() {
        return nElement == 0;
    }

    public boolean isFull() {
        return nElement == maxSize;
    }
}
