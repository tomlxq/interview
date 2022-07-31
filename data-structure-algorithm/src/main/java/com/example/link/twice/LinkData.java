package com.example.link.twice;

public class LinkData {
    public LinkData next;
    private int data;

    public LinkData(int data) {
        this.data = data;
    }

    public void display() {
        System.out.print(data + " ");
    }
}
