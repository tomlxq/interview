package com.tom.linkedlist;

import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/11/22
 */
@Slf4j
public class ReverseNode {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(3);
        ListNode head = myLinkedList.head;
        printLinkedList(head);

        ListNode newHead = reverseList(head);
        printLinkedList(newHead);

        ListNode newHead2 = reverseList2(newHead);
        printLinkedList(newHead2);
    }
    public static ListNode swapPairs(ListNode head) {
        ListNode pre=null;
       pre.next= head;
       while (pre.next!=null&&pre.next.next!=null){
           ListNode a=  pre.next;
           ListNode b=  a.next;
           pre.next=b;
           b.next=a;
           a.next=b.next;
           pre=a;
       }
       return null;
    }

    /**
     * 假设存在链表 1→2→3→∅，
     * 我们想要把它改成 ∅←1←2←3
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //当前节点的下一个指针存一下
            ListNode nextTemp = curr.next;
            //在遍历列表时，将当前节点的 next 指针改为指向前一个元素
            curr.next = prev;
            //将当前节点给前置节点
            prev = curr;
            //原来的下一个节点，给当前节点
            curr = nextTemp;
        }
        return prev;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.printf("%s\n", head.val);
            head = head.next;
        }
    }
}
