package com.example.link.stack;

public class LinkList {
    LinkData first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long data) {
        LinkData linkData = new LinkData(data);
        linkData.next = first;
        first = linkData;
    }

    public long deleteFirst() {
        LinkData tmp = first;
        first = first.next;
        return tmp.data;
    }

    public void displayList() {

        LinkData cur = first;
        while (cur != null) {
            cur.display();
            cur = cur.next;
        }
        System.out.println();
    }
}
