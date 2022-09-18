# 剑指 Offer 62. 圆圈中最后剩下的数字
## 题目
0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

## 思路

约瑟夫环

* 循环链表模拟
  假设当前长度为n，数到第m个(通过上面分析可以求余让这个有效的m不大于n)删除，在index位置删除。

* 有序集合模拟
  `index=(index+m-1)%(list.size());`
  因为index是从1计数，如果是循环的再往前m-1个就是真正的位置，但是这里可以先假设先将这个有序集合的长度扩大若干倍，然后从index计数开始找到假设不循环的位置index2，最后我们将这个位置index2%(集合长度)即为真正的长度。

* 递归公式解决

  ```
  f(10,3)=(f(9,3)+3)%10
  f(9,3)=(f(8,3)+3)%9
  ……
  f(2,3)=(f(1,3)+3)%2
  f(1,3)=0
  ```

  但是递归效率因为有个来回的规程，效率相比直接迭代差一些，也可从前往后迭代
  
## java

  ```java
  class SimpleNode {
         public SimpleNode(int val) {
            this.val = val;
       }
  
        int val;
        SimpleNode next;
  }
  public int lastRemaining(int n, int m) {
        //1.若m=1,则返回n节点的数字
        //2.模拟链表，首尾相接
        //3.设置报数为index,依次遍历至到m时，进行删除操作
        if (m == 1) {
            return n - 1;
        }
        SimpleNode head = new SimpleNode(0);
        SimpleNode team = head;
        for (int i = 1; i < n; i++) {
            team.next = new SimpleNode(i);
            team = team.next;
        }
        //首尾相接
        team.next = head;
        int index = 0;
        //4.设置报数为index初始值0,
        //5.当有多余的节点时
        // ①依次遍历至到m-2时，进行后一个节点删除操作，将报数归0
        // ②否则报数index+1
        // ③将下一个节点给当前节点，继续遍历
        while (head.next != head) {
       //效率不高，在m远大于n的情况下，会导致无数据转圈圈，可以将(m-2)%len来减少转圈次数，减少时间复杂度
            if (index == m - 2) {
                head.next = head.next.next;
                index = 0;
            } else {
                index++;
            }
            head = head.next;
        }
        return head.val;
    }
  class Solution {
     
    public int lastRemaining(int n, int m) {
         if (m == 1) {
            return n - 1;
        }
        List<Integer> list = IntStream.range(0, n).boxed().collect(Collectors.toList());
        int index = 0;
        while (list.size() > 1) {
            index = (index+ m - 1) % (list.size());
            list.remove(index);
        }
        return list.get(0);
    }
}
	class Solution {
    public int lastRemaining(int n, int m) {
      if (n == 1) {
            return 0;
        }
        return (lastRemaining(n-1,m)+m)%n;
    }
  }
  
  ```

  ## python

  ```python
	class Solution:
	  def lastRemaining(self, n: int, m: int) -> int:
        if m == 1:
            return n - 1
        list_data = list()
        for i in range(n):
            list_data.insert(i, i)
        idx = 0
        while len(list_data) > 1:
            idx = (idx + m - 1) % len(list_data)
            list_data.pop(idx)
        return list_data[0]
  	class Solution:
	  def lastRemaining(self, n: int, m: int) -> int:
        def lastRemaining1(n, m):
            if n==1:
                return 0
            return (lastRemaining1(n-1,m)+m)%n
        return lastRemaining1(n,m)
  	class Solution:
	  def lastRemaining(self, n: int, m: int) -> int:
        value = 0
        for i in range(1, n + 1):
            value = (value + m) % i
        return value
  ```

## 复杂度