package com.example.link.stack;

public class LinkData {
    protected long data;
    protected LinkData next;

    public LinkData(long data) {
        this.data = data;
    }

    public void display() {
        System.out.print(data + " ");
    }
}
