package com.example.link.stack;

import org.junit.Test;

public class StackLinkTest {
    @Test
    public void name() {
        //先进后出
        StackLink stackLink = new StackLink();
        stackLink.push(1334L);
        stackLink.push(1335L);
        stackLink.push(1336L);
        stackLink.push(1337L);
        stackLink.push(1338L);
        stackLink.push(1339L);
        stackLink.display();
        stackLink.pop();
        stackLink.pop();
        stackLink.pop();
        stackLink.pop();
        stackLink.display();
    }
}