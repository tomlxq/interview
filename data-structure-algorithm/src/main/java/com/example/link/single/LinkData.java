package com.example.link.single;

public class LinkData {
    public LinkData next;
    public int id;
    private double data;

    public LinkData(int id, double data) {
        this.id = id;
        this.data = data;
    }

    public void display() {
        System.out.print(" id=" + id + ",data=" + data);
    }
}
