# 数据结构和算法

## 数据结构

对计算机内存中的数据的安排

## 算法

对结构中的数据的进行各种处理

## 常见应用

现实世界的数据存储

程序员的工具

现实世界的建模

## 常用数据结构的优缺点

| 数据结构          | 优点                                 | 缺点                             |
| ----------------- | ------------------------------------ | -------------------------------- |
| 数组              | 插入快（知道下标）                   | 查找、删除慢，大小固定           |
| 有序数组          | 比无序数组查找快                     | 插入、删除慢(需要排序)，大小固定 |
| 栈                | 提供后进先出存取方式                 | 存取其它项慢                     |
| 队列              | 提供先进先出存取方式                 | 存取其它项慢                     |
| 链表              | 插入、删除快                         | 查找慢                           |
| 二叉树            | 插入、查找、删除快（树平衡的情况下） | 算法复杂                         |
| 红黑树（平衡树）  | 插入、查找、删除快                   | 算法复杂                         |
| 2-3-4树（平衡树） | 插入、查找、删除快                   | 算法复杂                         |
| 哈希表            | 插入快，通过关键字存取快             | 删除慢                           |
| 堆                | 插入、查找慢，对最大数据项的存取快   | 存取其它项慢                     |
| 图                | 对现实世界的建模                     | 有些算法慢且复杂                 |
|                   |                                      |                                  |

## 涉及到的术语

数据库

记录

字段

关键字





## **Java Program Structure**

### class类

对象的模型

public class 类名{

}

对象：类的实例（方法和变量）

### main method

```java
public class SimpleAddition {

    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        double c = a + b;
        System.out.println( a + " + " + b + " = " + c);
    }
}
```

### **Compiling and Executing a Program**

`javac SimpleAddition.java`

`java SimpleAddition`

## 常见数据类型

存在栈里

Let's start with a quick reference:

|   Type    | Size (bits) | Minimum |     Maximum      |             Example             |
| :-------: | ----------- | :-----: | :--------------: | :-----------------------------: |
|  *byte*   | 8           |  -2^7   |      2^7– 1      |         *byte b = 100;*         |
|  *short*  | 16          |  -2^15  |     2^15– 1      |       *short s = 30_000;*       |
|   *int*   | 32          |  -2^31  |     2^31– 1      |     *int i = 100_000_000;*      |
|  *long*   | 64          |  -2^63  |     2^63– 1      | *long l = 100_000_000_000_000;* |
|  *float*  | 32          | -2^-149 | (2-2^-23)·2^127  |       *float f = 1.456f;*       |
| *double*  | 64          | -2-1074 | (2-2^-52)·2^1023 | *double f = 1.456789012345678;* |
|  *char*   | 16          |    0    |     2^16– 1      |         *char c = ‘c';*         |
| *boolean* | 1           |    –    |        –         |       *boolean b = true;*       |

# 参考资料：

[operators in the Java language](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html)

