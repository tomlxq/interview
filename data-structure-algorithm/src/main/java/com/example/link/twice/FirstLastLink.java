package com.example.link.twice;

public class FirstLastLink {
    private LinkData first;
    private LinkData last;

    public FirstLastLink() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        LinkData linkData = new LinkData(data);
        if (isEmpty()) {
            last = linkData;
        } else {
            linkData.next = first;
        }
        first = linkData;
    }

    public void insertLast(int data) {
        LinkData linkData = new LinkData(data);
        if (isEmpty()) {
            first = linkData;
        } else {
            last.next = linkData;
        }
        last = linkData;
    }

    public LinkData deleteFirst() {
        LinkData tmp = first;
        if (tmp == null) {
            last = null;
        } else {
            first = tmp.next;
        }
        return tmp;
    }

    public void displayList() {
        System.out.print("list (last-->first):");
        LinkData cur = first;
        while (cur != null) {
            cur.display();
            cur = cur.next;
        }
        System.out.println();
    }
}
