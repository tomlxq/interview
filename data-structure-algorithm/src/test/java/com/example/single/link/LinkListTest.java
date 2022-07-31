package com.example.single.link;

import com.example.link.single.LinkData;
import com.example.link.single.LinkList;
import org.junit.Test;

public class LinkListTest {
    @Test
    public void test() {
        LinkList linkList = new LinkList();
        linkList.insertFirst(1, 5.4);
        linkList.insertFirst(2, -5.4);
        linkList.insertFirst(3, 5);
        linkList.insertFirst(4, 6.6);
        linkList.insertFirst(6, 2.1);
        linkList.displayList();
        while (!linkList.isEmpty()) {
            LinkData linkData = linkList.deleteFirst();
            System.out.print("delete ");
            linkData.display();
            System.out.println();
        }
        linkList.displayList();

        linkList = new LinkList();
        linkList.insertFirst(10, 59.4);
        linkList.insertFirst(20, -58.4);
        linkList.insertFirst(30, 59);
        linkList.insertFirst(40, 67.6);
        linkList.insertFirst(60, 72.1);
        linkList.displayList();

        LinkData linkData = linkList.find(30);
        if (linkData != null) {
            System.out.print("find");
            linkData.display();
            System.out.println();
        }
        LinkData delete = linkList.delete(40);
        if (delete != null) {
            System.out.print("delete");
            delete.display();
            System.out.println();
        }
        linkList.displayList();

    }
}