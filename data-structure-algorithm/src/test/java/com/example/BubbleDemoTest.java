package com.example;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BubbleDemoTest {
    String testString = "apple,bob,lishi,wangwu,zhangshan";
    BubbleDemo bubbleDemo;

    @Before
    public void setUp() throws Exception {
        bubbleDemo = new BubbleDemo(100);
        bubbleDemo.insert("zhangshan");
        bubbleDemo.insert("lishi");
        bubbleDemo.insert("wangwu");
        bubbleDemo.insert("apple");
        bubbleDemo.insert("bob");
        bubbleDemo.display();
    }

    @After
    public void tearDown() throws Exception {
        Assert.assertEquals(testString, bubbleDemo.display());
    }

    @Test
    public void bubbleTest() {
        bubbleDemo.order();
    }

    @Test
    public void selectTest() {
        bubbleDemo.orderSel();
    }

    @Test
    public void orderInsert() {
        bubbleDemo.orderInsert();
    }

}