package com.tom.one.java.base.domain;

import java.util.List;
import java.util.Queue;

/**
 * 【强制】类名使用 UpperCamelCase 风格，但以下情形例外：DO / BO / DTO / VO / AO / PO / UID 等。
 * 【强制】方法名、参数名、成员变量、局部变量都统一使用 lowerCamelCase 风格
 * 【强制】常量命名全部大写，单词间用下划线隔开，力求语义表达完整清楚，不要嫌名字长。
 * 【强制】抽象类命名使用 Abstract 或 Base 开头；异常类命名使用 Exception 结尾；测试类命名以它要测试的类的名称开始，以 Test 结尾。
 * 【强制】类型与中括号紧挨相连来表示数组。
 * 【强制】POJO 类中的任何布尔类型的变量，都不要加 is 前缀，否则部分框架解析会引起序列化错误。
 * 【强制】包名统一使用小写，点分隔符之间有且仅有一个自然语义的英语单词。包名统一使用单数形式，但是类名如果有复数含义，类名可以使用复数形式。
 * 【强制】避免在子父类的成员变量之间、或者不同代码块的局部变量之间采用完全相同的命名，使可理解性降低。
 * 【推荐】在常量与变量的命名时，表示类型的名词放在词尾，以提升辨识度。
 * 【推荐】如果模块、接口、类、方法使用了设计模式，在命名时需体现出具体模式。
 * 说明：将设计模式体现在名字中，有利于阅读者快速理解架构设计理念。
 * 正例： public class OrderFactory;
 * public class LoginProxy;
 * public class ResourceObserver;
 * 【推荐】接口类中的方法和属性不要加任何修饰符号（public 也不要加），保持代码的简洁性，并加上有效的 Javadoc 注释。尽量不要在接口里定义变量，如果一定要定义变量，确定与接口方法相关，并且是整个应用的基础常量。
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public class UserDO {
    int startTime ;
    Queue workQueue ;
    List nameList ;
    int TERMINATED_THREAD_COUNT;
    static long MAX_STOCK_COUNT = 10000L;
    static long CACHE_EXPIRED_TIME = 24 * 3600L;
    int localValue;
    int[] arrayDemo={1,2};

    public String getHttpMessage() {
        return null;
    }

    int inputUserId;

}
