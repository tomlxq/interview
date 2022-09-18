# 剑指 Offer 10- I. 斐波那契数列

## 题目
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

## 思路
暴力递归：
```
初始值 n<=1返回 n;  fb(n)=fb(n - 1) + fb(n - 2)
```
递归+忆化:
```
初始值 n<=1返回 n; 
mem[n]存在返回
不存在，mem[n]=fb(n - 1) + fb(n - 2)，返回mem[n]
```
双指针迭代：
```
初始值 low=0,high=1
i=2开始迭代
sum=low+high
low=high
high=sum
返回high
```
动态规划：
```
[i] 表示第i个数的斐波那契数
初始值 dp[0] = 0，  dp[1] = 1;
状态转方程 dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007
```
动态规划（压缩状态）：
```
初始值 prev = 0，  curr = 1;
状态转方程 curr = (prev + curr) % 1000000007
```
## 暴力递归
```python
class Solution:
    def fib(self, n: int) -> int:
        def fb(num: int) -> int:
            if num <= 1:
                return num
            return fb(num - 1) + fb(num - 2)

        return fb(n)
```
```java
class Solution {
    public int fib(int n) {
         if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
```
## 递归+忆化
```java
class Solution {
    public int fib(int n) {
         int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        return dfsFB(n, mem);
    }

    private int dfsFB(int n, int[] mem) {
        if (n <= 1) {
            return n;
        }
        if (mem[n] != -1) {
            return mem[n];
        }
        int left = dfsFB(n - 1, mem);
        int right = dfsFB(n - 2, mem);
        mem[n] = (left + right) % 1000000007;
        return mem[n];
    }
}
```

```python
class Solution:
    def fib(self, n: int) -> int:
        mem = [-1] * (n + 1)
        print(mem)
        def dbf(num: int) -> int:
            if num <= 1:
                return num
            if mem[num] != -1:
                return mem[num]
            left = dbf(num - 1)
            right = dbf(num - 2)

            mem[num] = (left + right) % 1000000007
            return mem[num]

        return dbf(n)
```
## 动态规划
```python
class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
```
```python
class Solution:
    def fib(self, n: int) -> int:
        if n <= 1:
            return n
        dp = [-1] * (n + 1)
        dp[0], dp[1] = 0, 1
        for i in range(2, n + 1):
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007
        return dp[n]
```
## 动态规划（压缩状态）
```java
class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int prev = 0,curr = 1;
        for (int i = 2; i < n + 1; i++) {
            int sum = (prev + curr) % 1000000007;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
```
```python
class Solution:
    def fib(self, n: int) -> int:
        if n <= 1:
            return n
        prev, curr = 0, 1
        for i in range(2, n + 1):
            total = (prev + curr) % 1000000007
            prev, curr = curr, total
        return curr
```