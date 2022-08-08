# 剑指 Offer II 024. 反转链表

## 题目

给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。

示例 1：

```
输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]
```

示例 2：

```
输入：head = [1,2]
输出：[2,1]
```


示例 3：

```
输入：head = []
输出：[]
```

## 迭代
java

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
       ListNode prev = null, next, curr = head;
       while (curr != null) {
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }
       return prev;
   }
}
```

python

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        prev = None
        curr = head
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        return prev
```

## 递归
java

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
*/
class Solution {
    public ListNode reverseList(ListNode head) {
       if (head == null || head.next == null) {
           return head;
       }
       ListNode newHead = reverseList(head.next);
       head.next.next = head;
       head.next = null;
       return newHead;
   }
}
```

python

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        new_node = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return new_node
```



