package com.tom.one.java.base.alibaba.guide;

/**
 * 20. 【推荐】当一个类有多个构造方法，或者多个同名方法，这些方法应该按顺序放置在一起，便
 * 于阅读，此条规则优先于下一条。
 * 21. 【推荐】 类内方法定义的顺序依次是：公有方法或保护方法 > 私有方法 > getter / setter
 * 方法。
 * 说明：公有方法是类的调用者和维护者最关心的方法，首屏展示最好；保护方法虽然只是子类关心，也可
 * 能是“模板设计模式”下的核心方法；而私有方法外部一般不需要特别关心，是一个黑盒实现；因为承载
 * 的信息价值较低，所有 Service 和 DAO 的 getter/setter 方法放在类体最后。
 * 22. 【推荐】setter 方法中，参数名称与类成员变量名称一致，this.成员名 = 参数名。在
 * getter/setter 方法中，不要增加业务逻辑，增加排查问题的难度。
 * 反例：
 * public Integer getData () {
 * if (condition) {
 * return this.data + 100;
 * } else {
 * return this.data - 100;
 * }
 * }
 * 23. 【推荐】循环体内，字符串的连接方式，使用 StringBuilder 的 append 方法进行扩展。
 * 说明：下例中，反编译出的字节码文件显示每次循环都会 new 出一个 StringBuilder 对象，然后进行 append
 * 操作，最后通过 toString 方法返回 String 对象，造成内存资源浪费。
 * 反例：
 * String str = "start";
 * for (int i = 0; i < 100; i++) {
 * str = str + "hello";
 * }
 * 24. 【推荐】 final 可以声明类、成员变量、方法、以及本地变量，下列情况使用 final 关键字：
 * 1） 不允许被继承的类，如：String 类。
 * 2） 不允许修改引用的域对象，如：POJO 类的域变量。
 * 3） 不允许被覆写的方法，如：POJO 类的 setter 方法。
 * 4） 不允许运行过程中重新赋值的局部变量。
 * 5） 避免上下文重复使用一个变量，使用 final 关键字可以强制重新定义一个变量，方便更好地进行重构。
 * 25. 【推荐】慎用 Object 的 clone 方法来拷贝对象。
 * 说明：对象 clone 方法默认是浅拷贝，若想实现深拷贝，需覆写 clone 方法实现域对象的深度遍历式拷贝。
 * 26. 【推荐】类成员与方法访问控制从严：
 * 1） 如果不允许外部直接通过 new 来创建对象，那么构造方法必须是 private。
 * 2） 工具类不允许有 public 或 default 构造方法。
 * 3） 类非 static 成员变量并且与子类共享，必须是 protected。
 * 4） 类非 static 成员变量并且仅在本类使用，必须是 private。
 * Java 开发手册
 * 11/59
 * 5） 类 static 成员变量如果仅在本类使用，必须是 private。
 * 6） 若是 static 成员变量，考虑是否为 final。
 * 7） 类成员方法只供类内部调用，必须是 private。
 * 8） 类成员方法只对继承类公开，那么限制为 protected。
 * 说明：任何类、方法、参数、变量，严控访问范围。过于宽泛的访问范围，不利于模块解耦。思考：如果
 * 是一个 private 的方法，想删除就删除，可是一个 public 的 service 成员方法或成员变量，删除一下，不
 * 得手心冒点汗吗？变量像自己的小孩，尽量在自己的视线内，变量作用域太大，无限制的到处跑，那么你
 * 会担心的。
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public class ClassExample {
}
