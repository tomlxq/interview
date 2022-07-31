package com.example.link.twice;

import org.junit.Test;

public class FirstLastLinkTest {
    @Test
    public void name() {
        FirstLastLink firstLastLink = new FirstLastLink();
        firstLastLink.insertFirst(15);
        firstLastLink.insertFirst(66);
        firstLastLink.insertFirst(88);
        firstLastLink.insertLast(46);
        firstLastLink.insertLast(49);
        firstLastLink.insertLast(90);
        firstLastLink.displayList();
        firstLastLink.deleteFirst();
        firstLastLink.deleteFirst();
        firstLastLink.displayList();
    }
}