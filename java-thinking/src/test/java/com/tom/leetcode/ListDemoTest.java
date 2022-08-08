package com.tom.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListDemoTest {
    ListDemo ld;
    ListNode l1;

    @Before
    public void setUp() throws Exception {
        ld = new ListDemo();
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        l1 = new ListNode(1, l2);
    }

    @Test
    public void reverseList() {

        ListNode pre = ld.reverseList(l1);
        Assert.assertEquals(5, pre.val);
        Assert.assertEquals(4, pre.next.val);

    }

    @Test
    public void reverseList2() {
        ListNode pre = ld.reverseList2(l1);
        Assert.assertEquals(5, pre.val);
        Assert.assertEquals(4, pre.next.val);
    }

    @Test
    public void hasCycle() {
        ListNode l4 = new ListNode(-4, null);
        ListNode l0 = new ListNode(0, l4);
        ListNode l2 = new ListNode(2, l0);
        ListNode l3 = new ListNode(3, l2);
        l4.next = l2;
        Assert.assertTrue(ld.hasCycle(l3));
        ListNode node2 = new ListNode(2, null);
        ListNode node1 = new ListNode(2, node2);
        node2.next = node1;
        Assert.assertTrue(ld.hasCycle2(node1));

    }
}