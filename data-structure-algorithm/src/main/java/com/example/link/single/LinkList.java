package com.example.link.single;

public class LinkList {
    private LinkData first;

    public LinkList() {
        first = null;
    }

    public void insertFirst(int id, double data) {
        LinkData linkData = new LinkData(id, data);
        linkData.next = first;
        first = linkData;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public LinkData deleteFirst() {
        LinkData tmp = first;
        first = first.next;
        return tmp;
    }

    public LinkData find(int id) {
        LinkData cur = first;
        while (cur.id != id) {
            if (cur.next == null) {
                return null;
            }
            cur = cur.next;
        }
        return cur;
    }

    public LinkData delete(int id) {
        LinkData cur = first;
        LinkData pre = first;
        while (cur.id != id) {
            if (cur.next == null) {
                return null;
            }
            pre = cur;
            cur = cur.next;
        }
        if (cur == first) {
            first = cur.next;
            return pre;
        } else {
            pre.next = cur.next;
        }
        return cur;
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
