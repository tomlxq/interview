package com.example.link.stack;

public class StackLink {
    private LinkList linkList;

    public StackLink() {
        linkList = new LinkList();
    }

    public void push(long data) {
        linkList.insertFirst(data);
    }

    public long pop() {
        return linkList.deleteFirst();
    }

    public void display() {
        System.out.print("stack (top-->bottom):");
        linkList.displayList();
    }
}
